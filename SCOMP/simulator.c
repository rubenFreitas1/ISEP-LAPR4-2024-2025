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


//MÉTODO MAIN DO SIMULADOR
void simulator_run(const char* fileName) {
    DroneData* allData = NULL;
    int totalDrones = 0;
	//MatrixCellInfo matrix[MAX_X][MAX_Y][MAX_Z] = {0};
    int totalPositions = readCsv(fileName, &allData, &totalDrones);
    int fd_1[totalDrones][2]; // pipes de comunicação de pai -> drone
    int fd_2[totalDrones][2]; // pipes de comunicação de drone -> pai
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
	//printTimestamps(timestamps, timestampCount);
	
	for(int i= 0; i < totalDrones; i++){
		pids[i] = fork();
		if(pids[i] == 0){
			close(fd_1[i][1]); // fechar write root->drone
			close(fd_2[i][0]); // fechar read drone->root
			int myDroneID = i + 1;
			int dronePositions = 0;
			DroneData* droneData = NULL;
			getSpecificDroneData(allData, totalPositions, &droneData, myDroneID, &dronePositions);
			//printDroneData(myDroneID, droneData, dronePositions);
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
	
	for (int i = 0; i < timestampCount; i++) {
		int currentTimestamp = timestamps[i];
		for(int d = 0; d < totalDrones; d++){
			write(fd_1[d][1], &currentTimestamp, sizeof(int));
			printf("[ROOT] SEND CURRENT TIMESTAMP (%ds) FOR DRONE: %d\n", currentTimestamp, d+1);
		}
		
		for (int d = 0; d < totalDrones; d++) {
			DroneData position;
			read(fd_2[d][0], &position, sizeof(DroneData));
			printf("[ROOT] RECEIVED POSITION (%.2f, %.2f, %.2f) FROM DRONE: %d IN TIMESTAMP %ds\n", position.x, position.y, position.z, position.droneID, position.timestamp);
			if(position.timestamp < 0){
				printf("Drone %d does not change the position in timestamp %ds!\n", d+1, currentTimestamp);
			}else{
				//funçao para atualizar matrix e ver se tem colisões!!!
			}
		}
		
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
	
	printf("[ROOT] Simulação concluída com sucesso.\n");
	
	free(timestamps);
    free(allData);
}




