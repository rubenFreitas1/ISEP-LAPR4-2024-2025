#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h>
#include <errno.h>
#include <signal.h>
#include <string.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>

#include "simulator.h"

int myDroneID = 0;

void signal_handler(int sig, siginfo_t *si, void *context) {
	(void)sig;
    (void)si;
    (void)context;
    char buffer[64];
    char bufferDroneID[12];

    intToStr(myDroneID, bufferDroneID);
    strcpy(buffer, "[DRONE ");
    strcat(buffer, bufferDroneID);
    strcat(buffer, "] Received SIGUSR1 !\n");

    write(STDOUT_FILENO, buffer, strlen(buffer));
}


//MÉTODO PARA EXTRAIR TODOS OS TIMESTAMPS UNICOS
int* getAllTimestamps(DroneData* data, int totalPositions, int* count){
	int* temp = malloc(sizeof(int) * totalPositions);
	if (temp == NULL) {
		perror("Error trying to allocate memory to timestamps!");
		exit(EXIT_FAILURE);
	}
    int uniqueCount = 0;

    for (int i = 0; i < totalPositions; i++) {
        int ts = data[i].timestamp;
        int exists = 0;
        for (int j = 0; j < uniqueCount; j++) {
            if (temp[j] == ts) {
                exists = 1;
                break;
            }
        }

        if (!exists) {
            temp[uniqueCount] = ts;
            uniqueCount++;
        }
    }
    
     bubbleSort(temp, uniqueCount);
     *count = uniqueCount;
     return temp;
}


// MÉTODO PARA CADA DRONE TIRAR AS SUAS POSIÇÕES DO DroneData GERAL COM TODAS AS INFORMAÇÕES
void getSpecificDroneData(DroneData* data,int positions, DroneData** droneData, int droneID, int* count){
	*count = 0;
    for (int i = 0; i < positions; ++i) {
        if (data[i].droneID == droneID) {
            (*count)++;
        }
    }
	*droneData = malloc(sizeof(DroneData) * (*count));
	if (*droneData == NULL) {
        perror("Error trying to allocate memory for droneData!");
        exit(EXIT_FAILURE);
    }
    
    int idx = 0;
	for(int i = 0; i < positions; ++i){
		if(droneID == data[i].droneID){
			(*droneData)[idx] = data[i];
			idx++;
		}
	}
}

//Método que atualiza a matriz temporária com a posição do drone
int updateMatrix(MatrixCellInfo matrix[MAX_X][MAX_Y][MAX_Z], DroneData data) {
    int x = data.x;
    int y = data.y;
    int z = data.z;
    
    if(matrix[x][y][z].droneID != 0 && matrix[x][y][z].droneID != data.droneID){
		return matrix[x][y][z].droneID;
	} else {
		matrix[x][y][z].droneID = data.droneID;
		matrix[x][y][z].timestamp = data.timestamp;
		return 0;
	}
}

//Método para substituir a matriz principal pela temporária
void storeTempMatrix(MatrixCellInfo matrix[MAX_X][MAX_Y][MAX_Z], MatrixCellInfo tempMatrix[MAX_X][MAX_Y][MAX_Z]) {
    for (int x = 0; x < MAX_X; x++) {
        for (int y = 0; y < MAX_Y; y++) {
            for (int z = 0; z < MAX_Z; z++) {
                matrix[x][y][z] = tempMatrix[x][y][z];
            }
        }
    }
}

//Método para verificar se uma posição é válida
int isPositionValid(int x, int y, int z) {
    return x >= 0 && x < MAX_X && y >= 0 && y < MAX_Y && z >= 0 && z < MAX_Z;
}

//Método para encontrar a posição adjacente mais próxima da colisão
DroneData findFreeAdjacentPosition(MatrixCellInfo tempMatrix[MAX_X][MAX_Y][MAX_Z], DroneData original) {
    int origX = (int)original.x;
    int origY = (int)original.y;
    int origZ = (int)original.z;

    int maxRadius = (MAX_X > MAX_Y ? MAX_X : MAX_Y);
    if (MAX_Z > maxRadius) maxRadius = MAX_Z;

    for (int radius = 1; radius < maxRadius; radius++) {

        int xPos[2] = {origX + radius, origX - radius};
        for (int i = 0; i < 2; i++) {
            if (isPositionValid(xPos[i], origY, origZ) && tempMatrix[xPos[i]][origY][origZ].droneID == 0) {
                DroneData newData = original;
                newData.x = xPos[i];
                return newData;
            }
        }

        int yPos[2] = {origY + radius, origY - radius};
        for (int i = 0; i < 2; i++) {
            if (isPositionValid(origX, yPos[i], origZ) && tempMatrix[origX][yPos[i]][origZ].droneID == 0) {
                DroneData newData = original;
                newData.y = yPos[i];
                return newData;
            }
        }

        int zPos[2] = {origZ + radius, origZ - radius};
        for (int i = 0; i < 2; i++) {
            if (isPositionValid(origX, origY, zPos[i]) && tempMatrix[origX][origY][zPos[i]].droneID == 0) {
                DroneData newData = original;
                newData.z = zPos[i];
                return newData;
            }
        }
    }
    return original;
}



//MÉTODO MAIN DO SIMULADOR
void simulator_run(const char* fileName, int maxCollisions) {
    DroneData* allData = NULL;
    int totalDrones = 0;
    int collisions = 0;
    int auxMatrix = 0;
	MatrixCellInfo matrix[MAX_X][MAX_Y][MAX_Z] = {0};

	int droneStatus = 1;
    int totalPositions = readCsv(fileName, &allData, &totalDrones);

    char baseName[100];
    getBaseName(fileName, baseName);

    char reportFile[150];
    snprintf(reportFile, sizeof(reportFile), "simulation_report_%s.txt", baseName);
	FILE* report = fopen(reportFile, "w");
	if (report == NULL) {
		perror("Error opening report file");
		exit(EXIT_FAILURE);
	}


    int fd_1[totalDrones][2]; // pipes de comunicação de pai -> drone
    int fd_2[totalDrones][2]; // pipes de comunicação de drone -> pai

    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = signal_handler;
    act.sa_flags = SA_RESTART;
    sigaction(SIGUSR1, &act, NULL);

    for (int i = 0; i < totalDrones; i++) {
		if (pipe(fd_1[i]) == -1 || pipe(fd_2[i]) == -1) {
			perror("Error creatring pipe!");
			exit(EXIT_FAILURE);
		}
	}
    pid_t pids[totalDrones];
    simulator_info(allData, totalPositions, totalDrones);
	int timestampCount = 0;
	int* timestamps = getAllTimestamps(allData, totalPositions, &timestampCount);

	for(int i= 0; i < totalDrones; i++){
		pids[i] = fork();
		if(pids[i] == 0){
			close(fd_1[i][1]); // fechar write root->drone
			close(fd_2[i][0]); // fechar read drone->root
			myDroneID = i + 1;
			int dronePositions = 0;
			DroneData* droneData = NULL;
			getSpecificDroneData(allData, totalPositions, &droneData, myDroneID, &dronePositions);
			int ts;
			int currentIndex = 0;
			while (read(fd_1[i][0], &ts, sizeof(int)) > 0) {
				if (ts == -999) {
					break;  // Finaliza a execução do drone
				}
				printf("[DRONE %d] READ TIMESTAMP (%ds)\n", myDroneID, ts);
				if(currentIndex >= dronePositions){ break;}
				while(currentIndex < dronePositions && droneData[currentIndex].timestamp < ts){
					currentIndex++;   // avança o currentIndex enquando estiver menor que o timestamp // evito fazer verificações em timestamps menores
				}
				if(currentIndex < dronePositions && droneData[currentIndex].timestamp == ts){
					write(fd_2[i][1], &droneData[currentIndex], sizeof(DroneData));
					printf("[DRONE %d] SEND TO ROOT MY POSITION ON TIMESTAMP (%ds)\n", myDroneID, ts);
					currentIndex++;
				}else{
					DroneData empty = {0};
					empty.droneID = myDroneID;
					empty.timestamp = -1;
					empty.x = -1;
					empty.y = -1;
					empty.z = -1;
					write(fd_2[i][1], &empty, sizeof(DroneData));
				}
			}
			close(fd_1[i][0]);
			close(fd_2[i][1]);
			free(droneData);
			exit(0);

		}
	}

	writeHeader(report, totalDrones);

	for (int i = 0; i < timestampCount; i++) {
		int currentTimestamp = timestamps[i];
		for(int d = 0; d < totalDrones; d++){
			write(fd_1[d][1], &currentTimestamp, sizeof(int));
			printf("[ROOT] SEND CURRENT TIMESTAMP (%ds) FOR DRONE: %d\n", currentTimestamp, d+1);
		}
		MatrixCellInfo tempMatrix[MAX_X][MAX_Y][MAX_Z] = {0};
		for (int d = 0; d < totalDrones; d++) {
			DroneData position;
			read(fd_2[d][0], &position, sizeof(DroneData));
			printf("[ROOT] RECEIVED POSITION (%.2f, %.2f, %.2f) FROM DRONE: %d IN TIMESTAMP %ds\n", position.x, position.y, position.z, position.droneID, position.timestamp);
			if(position.timestamp < 0){
				printf("Drone %d does not change the position in timestamp %ds!\n", d+1, currentTimestamp);
			}else{
				auxMatrix = updateMatrix(tempMatrix, position);
				if(auxMatrix != 0){
					kill(pids[d],SIGUSR1);
					kill(pids[auxMatrix-1], SIGUSR1);
					collisions++;
					
					if(collisions>=maxCollisions){
						printf("\n\n");
						printf("COLLISION THRESHOLD HIT! Simulation terminated.\n");

						int endTimestamp = -999;
						for (int d = 0; d < totalDrones; d++) {
							write(fd_1[d][1], &endTimestamp, sizeof(int));
							printf("[ROOT] SEND TERMINATION SIGNAL FOR DRONE: %d\n", d + 1);
						}

						for (int i = 0; i < totalDrones; i++) {
							waitpid(pids[i], NULL, 0);
							printf("!!!DRONE %d ABORTED!!!\n", i + 1);
						}
						droneStatus = 0;

						writeExecutionStatus(report, droneStatus, collisions);
						writeValidationStatus(report, 0);
						fclose(report);

						printf("\n\n");
						printf("[ROOT] SIMULATION ABORTED.\n");

						free(timestamps);
						free(allData);
						exit(0);
					}
					
					DroneData newPos = findFreeAdjacentPosition(tempMatrix, position);
					updateMatrix(tempMatrix,newPos);
					printf("[ROOT] Drone %d redirected to new position (%.2f, %.2f, %.2f) after collision.\n", position.droneID, newPos.x, newPos.y, newPos.z);
					
					logCollision(report, position.timestamp, position.x, position.y, position.z, position.droneID, auxMatrix, newPos.x, newPos.y, newPos.z);
					
				}
			}
		}
		storeTempMatrix(matrix, tempMatrix);
	}

	int endTimestamp = -999;
	for (int d = 0; d < totalDrones; d++) {
		write(fd_1[d][1], &endTimestamp, sizeof(int));
		printf("[ROOT] SEND TERMINATION SIGNAL FOR DRONE: %d\n", d + 1);
	}

	for (int i = 0; i < totalDrones; i++) {
		waitpid(pids[i], NULL, 0);
		printf("!!!DRONE %d FINISHED!!!\n", i + 1);
	}

	printf("\n\n");
	printf("[ROOT] SIMULATION COMPLETED.\n");

	writeExecutionStatus(report, droneStatus, collisions);
	writeValidationStatus(report, 1);
	fclose(report);
	
	free(timestamps);
    free(allData);
}




