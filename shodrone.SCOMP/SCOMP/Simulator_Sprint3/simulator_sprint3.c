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
#include <semaphore.h>
#include <pthread.h>
#include "simulator_sprint3.h"

int myDroneID = 0;
sem_t *sem_write, *sem_read, *sem_colisions_read,*sem_colisions_write , *sem_barrier, *sem_arrival;
int fd, fd_1, fd_2;
shared_positions *shared_struct;
DroneData* shared_struct_list;
report_info* shared_info_struct;
pthread_t collision_thread, report_thread;
int* timestamps;
DroneData* allData;
MatrixCellInfo matrix[MAX_X][MAX_Y][MAX_Z] = {0};
int totalDrones = 0;
int collisionIndicator = 0;
int collisions = 0;
ThreadArgs* threadArgs;
char str[STR_SIZE];
int simulationStatus = 1;

int should_log = 0;

char baseName[100];
char reportFile[150];
FILE* report;

pthread_mutex_t mutex;
pthread_cond_t cond;


void cleanup() {
	
	free(timestamps);
    free(allData);
	
    if (sem_write != SEM_FAILED) {
        sem_close(sem_write);
        sem_unlink("/sem_write");
    }

    if (sem_read != SEM_FAILED) {
        sem_close(sem_read);
        sem_unlink("/sem_read");
    }
    
    if (sem_arrival != SEM_FAILED) {
        sem_close(sem_arrival);
        sem_unlink("/sem_arrival");
    }
    if (sem_colisions_read != SEM_FAILED) {
        sem_close(sem_colisions_read);
        sem_unlink("/sem_colisions_read");
    }

    if (sem_colisions_write != SEM_FAILED) {
        sem_close(sem_colisions_write);
        sem_unlink("/sem_colisions_write");
    }
    
    if (sem_barrier != SEM_FAILED) {
        sem_close(sem_barrier);
        sem_unlink("/sem_barrier");
    }

    //if (shared_struct != NULL && shared_struct->drone_positions != NULL) {
      //  free(shared_struct->drone_positions);
    //}

    if (shared_struct != NULL) {
        munmap(shared_struct, sizeof(shared_positions));
    }

    if (fd != -1) {
        close(fd);
        shm_unlink("/shared_struct");
    }
    
    if (shared_struct_list != NULL) {
        munmap(shared_struct_list, sizeof(DroneData)*totalDrones);
    }
    
    if (fd_1 != -1) {
        close(fd_1);
        shm_unlink("/shared_struct_list");
    }
    
    if (shared_info_struct != NULL) {
        munmap(shared_info_struct, sizeof(report_info));
    }

    if (fd_2 != -1) {
        close(fd_2);
        shm_unlink("/shared_info_struct");
    }
    
	pthread_join(collision_thread,NULL);
	pthread_join(report_thread, NULL);
    printf("[ROOT] Cleanup completed successfully.\n");
}
 
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


//void* report_generation_thread(){
//	
//}



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
    snprintf(str, STR_SIZE, "tou dentro do update \n");
	write(STDOUT_FILENO, str, strlen(str));
    if(matrix[x][y][z].droneID != 0 && matrix[x][y][z].droneID != data.droneID){
		return matrix[x][y][z].droneID;
	} else {
		matrix[x][y][z].droneID = data.droneID;
		matrix[x][y][z].timestamp = data.timestamp;
		return 0;
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

void* colision_detection_thread(void* arg){	
	ThreadArgs* args = (ThreadArgs*)arg;
	int* pidsAux = args->pids;
    int totalDrones = args->totalDrones;
    int maxCollisions = args->maxCollisions;
	while(1){
		sem_wait(sem_colisions_read);
		
		snprintf(str, STR_SIZE, "estou dentro do collisions \n");
		write(STDOUT_FILENO, str, strlen(str));
		
		pthread_mutex_lock(&mutex);
		
		if (shared_struct->timestamp == -999) {
			pthread_cond_signal(&cond);
			pthread_mutex_unlock(&mutex);
			break;
		}
		
		for(int i = 0; i < totalDrones; i++){
			DroneData position = shared_struct_list[i];
			
			snprintf(str, STR_SIZE, "Posiçao deste drone %d : (%f,%f,%f) \n", position.droneID, position.x,position.y,position.z);
			write(STDOUT_FILENO, str, strlen(str));
			
			if(position.timestamp < 0){
				snprintf(str, STR_SIZE, "Drone %d does not change the position in timestamp %ds!\n",position.droneID, position.timestamp);
				write(STDOUT_FILENO, str, strlen(str));
			}else{
				collisionIndicator = updateMatrix(matrix, position);
				
				snprintf(str, STR_SIZE, "resultado update %d \n", collisionIndicator);
				write(STDOUT_FILENO, str, strlen(str));
				
				if(collisionIndicator != 0){
					kill(pidsAux[i],SIGUSR1);
					kill(pidsAux[collisionIndicator-1], SIGUSR1);
					shared_struct_list[i].collisions++;
					shared_struct_list[collisionIndicator-1].collisions++;
					
					collisions++;
					
					DroneData newPos = findFreeAdjacentPosition(matrix, position);
					updateMatrix(matrix,newPos);
					shared_info_struct->hitDroneID = collisionIndicator;
					shared_info_struct->collisionDrone = position;
					shared_info_struct->realocatedDrone = newPos;
					
					if(collisions>=maxCollisions){
						simulationStatus = 0;
						shared_struct->timestamp = -999;
						
						pthread_cond_signal(&cond);
						pthread_mutex_unlock(&mutex);
						
						break;
						
					}
					
				
					
					should_log = 1;
					pthread_cond_signal(&cond);
					
				}
			}
		}
		pthread_mutex_unlock(&mutex);
		
		snprintf(str, STR_SIZE, "estou a sair do collisions \n");
		write(STDOUT_FILENO, str, strlen(str));
		
		sem_post(sem_colisions_write);
	}
	sem_post(sem_colisions_write);
	snprintf(str, STR_SIZE, "COLLISIONS ACABOU \n");
	write(STDOUT_FILENO, str, strlen(str));
	return NULL;
}


void* report_generation_thread (){
	pthread_mutex_lock(&mutex);	
	while(1){
		while (!should_log && shared_struct->timestamp != -999) {
			pthread_cond_wait(&cond, &mutex);
		}
		
		if(!simulationStatus){
			logCollision(report, shared_info_struct->collisionDrone.timestamp, shared_info_struct->collisionDrone.x, shared_info_struct->collisionDrone.y, shared_info_struct->collisionDrone.z, shared_info_struct->collisionDrone.droneID, shared_info_struct->hitDroneID, shared_info_struct->realocatedDrone.x, shared_info_struct->realocatedDrone.y, shared_info_struct->realocatedDrone.z);
		}

		if (shared_struct->timestamp == -999) {
			pthread_mutex_unlock(&mutex);
			break;
		}
		
		logCollision(report, shared_info_struct->collisionDrone.timestamp, shared_info_struct->collisionDrone.x, shared_info_struct->collisionDrone.y, shared_info_struct->collisionDrone.z, shared_info_struct->collisionDrone.droneID, shared_info_struct->hitDroneID, shared_info_struct->realocatedDrone.x, shared_info_struct->realocatedDrone.y, shared_info_struct->realocatedDrone.z);
		
		should_log = 0;
	}
	writeExecutionStatus(report, collisions, totalDrones, shared_struct_list, simulationStatus); 
	writeValidationStatus(report, simulationStatus);
	fflush(report);
	snprintf(str, STR_SIZE, "REPORT THREAD ACABOU \n");
	write(STDOUT_FILENO, str, strlen(str));
	return NULL;
}

void initialize_semaphores(){
	if((sem_write = sem_open("/sem_write",O_CREAT,0644,0))==SEM_FAILED){
        perror("sem_open sem_write");
        exit(4);
    }
    
    if((sem_read = sem_open("/sem_read",O_CREAT,0644,0))==SEM_FAILED){
        perror("sem_open sem_read");
        exit(4);
    }
    
    if((sem_colisions_write = sem_open("/sem_colisions_write",O_CREAT,0644,1))==SEM_FAILED){
        perror("sem_open sem_colisions_write");
        exit(4);
    }
    
    if((sem_colisions_read = sem_open("/sem_colisions_read",O_CREAT,0644,0))==SEM_FAILED){
        perror("sem_open sem_colisions_read");
        exit(4);
    }
    
    if((sem_barrier = sem_open("/sem_barrier", O_CREAT, 0644, 0))==SEM_FAILED){
		perror("sem_open sem_barrier");
        exit(4);
	}
	
	if((sem_arrival = sem_open("/sem_arrival", O_CREAT, 0644, 0)) == SEM_FAILED){
		perror("sem_open sem_arrival");
		exit(4);
	}
}

void initialize_shared_memories(){
	if((fd = shm_open("/shared_struct", O_CREAT|O_RDWR, S_IRUSR|S_IWUSR)) == -1){
		perror("shm_open error");
		exit(1);
	}
	
	if(ftruncate(fd, sizeof(shared_positions))== -1){
		perror("ftruncate error");
		exit(2);
	}
	
	if((shared_struct = (shared_positions*)mmap(0, sizeof(shared_positions), PROT_READ|PROT_WRITE, MAP_SHARED, fd, 0))== MAP_FAILED){
		perror("nmaps error");
		exit(3);
	}
	
	if((fd_1 = shm_open("/shared_struct_list", O_CREAT | O_RDWR, S_IRUSR | S_IWUSR)) == -1) {
		perror("shm_open error");
		exit(1);
	}

	if (ftruncate(fd_1, sizeof(DroneData) * totalDrones) == -1) {
		perror("ftruncate error");
		exit(2);
	}
	
	if((shared_struct_list = (DroneData*)mmap(0, sizeof(DroneData)*totalDrones, PROT_READ|PROT_WRITE, MAP_SHARED, fd_1, 0))== MAP_FAILED){
		perror("nmaps error");
		exit(3);
	}
	
	if((fd_2 = shm_open("/shared_info_struct", O_CREAT|O_RDWR, S_IRUSR|S_IWUSR)) == -1){
		perror("shm_open error");
		exit(1);
	}
	
	if (ftruncate(fd_2, sizeof(report_info)) == -1) {
		perror("ftruncate error");
		exit(2);
	}
	
	if((shared_info_struct = (report_info*)mmap(0, sizeof(report_info), PROT_READ|PROT_WRITE, MAP_SHARED, fd_2, 0))== MAP_FAILED){
		perror("nmaps error");
		exit(3);
	}
}

void simulator_run(const char* fileName, int maxCollisions) {
	allData = NULL;
    int totalPositions = readCsv(fileName, &allData, &totalDrones);
    int timestampCount = 0;
    timestamps = getAllTimestamps(allData, totalPositions, &timestampCount);
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_sigaction = signal_handler;
    act.sa_flags = SA_RESTART;
    sigaction(SIGUSR1, &act, NULL);
    pid_t pids[totalDrones];
    int pidsList[totalDrones];
    
    getBaseName(fileName, baseName);
    snprintf(reportFile, sizeof(reportFile), "simulation_report_%s.txt", baseName);
    report = fopen(reportFile, "w");
    if (report == NULL) {
		perror("Error opening report file");
		exit(EXIT_FAILURE);
	}
	writeHeader(report, totalDrones); 
	fflush(report);

	initialize_shared_memories();
	for (int k = 0; k < totalDrones; ++k){
		shared_struct_list[k].collisions = 0;
	}
	initialize_semaphores();
	
	shared_info_struct->maxcollisions = maxCollisions;
	
	
	threadArgs = malloc(sizeof(ThreadArgs));
    if (threadArgs == NULL) {
		perror("Failed to allocate memory for threadArgs");
		exit(EXIT_FAILURE);
	}
	threadArgs->pids = pidsList;
	threadArgs->totalDrones = totalDrones;
	threadArgs->maxCollisions = maxCollisions;
 
	if (pthread_mutex_init(&mutex, NULL) != 0) {
		perror("pthread_mutex_init failed");
		exit(EXIT_FAILURE);
	}
	if (pthread_cond_init(&cond, NULL) != 0) {
		perror("pthread_cond_init failed");
		exit(EXIT_FAILURE);
	}
	
	pthread_create(&collision_thread, NULL, colision_detection_thread, (void*)threadArgs);
	pthread_create(&report_thread, NULL, report_generation_thread, NULL);
	
	for(int i= 0; i < totalDrones; i++){
		pids[i] = fork();
		pidsList[i] = pids[i];
		if(pids[i] == 0){
			fclose(report);
			myDroneID = i + 1;
			int dronePositions = 0;
			DroneData* droneData = NULL;
			getSpecificDroneData(allData, totalPositions, &droneData, myDroneID, &dronePositions);
			int currentIndex = 0;
			while(1){
				sem_wait(sem_read);
				if (shared_struct->timestamp == -999) {
					sem_post(sem_write);
					snprintf(str, STR_SIZE, "DRONE %d A SAIR\n",myDroneID);
					write(STDOUT_FILENO, str, strlen(str));
					break;
				}
				snprintf(str, STR_SIZE, "[DRONE %d] READ TIMESTAMP (%ds)\n", myDroneID, shared_struct->timestamp);
				write(STDOUT_FILENO, str, strlen(str));
				if(currentIndex >= dronePositions){ break;}
				while(currentIndex < dronePositions && droneData[currentIndex].timestamp < shared_struct->timestamp){
					currentIndex++;
				}
				if(currentIndex < dronePositions && droneData[currentIndex].timestamp == shared_struct->timestamp){
					int prev = shared_struct_list[i].collisions;
					shared_struct_list[i] = droneData[currentIndex];
					shared_struct_list[i].collisions = prev;
					snprintf(str, STR_SIZE, "[DRONE %d] SEND TO ROOT MY POSITION, (%.2f, %.2f, %.2f) ,ON TIMESTAMP (%ds)\n", myDroneID, shared_struct_list[i].x, shared_struct_list[i].y, shared_struct_list[i].z, shared_struct_list[i].timestamp);
					write(STDOUT_FILENO, str, strlen(str));
				}else{
					DroneData empty = {0};
					empty.droneID = myDroneID;
					empty.timestamp = -1;
					empty.x = -1;
					empty.y = -1;
					empty.z = -1;
					shared_struct_list[i] = empty;
				}
				sem_post(sem_arrival);
				sem_wait(sem_barrier);
			}
			free(droneData);
			exit(0);
		}
	}
	
	for (int i = 0; i < timestampCount; i++) {
		sem_wait(sem_colisions_write);
		if (!simulationStatus){
			break;
		}
		snprintf(str, STR_SIZE, "NOVO TIMESTAMP \n");
		write(STDOUT_FILENO, str, strlen(str));
		memset(matrix, 0, sizeof(matrix));
		shared_struct->timestamp = timestamps[i];
		snprintf(str, STR_SIZE, "[ROOT] SEND CURRENT TIMESTAMP (%ds)\n", timestamps[i]);
		write(STDOUT_FILENO, str, strlen(str));
		for (int j = 0; j < totalDrones; j++) {
			sem_post(sem_read);
		}
		for (int j = 0; j < totalDrones; j++) {
			sem_wait(sem_arrival);
		}
		for (int j = 0; j < totalDrones; j++) {
			sem_post(sem_barrier);
		}
		snprintf(str, STR_SIZE, "A ENTRAR NO COLLISIONS\n");
		write(STDOUT_FILENO, str, strlen(str));	
		sem_post(sem_colisions_read);
		if (i == timestampCount - 1) { 
			sem_wait(sem_colisions_write);
		}
	}
	
	shared_struct->timestamp = -999;
	for (int j = 0; j < totalDrones; j++) {
		sem_post(sem_read);
	}
	for (int j = 0; j < totalDrones; j++) {
		sem_wait(sem_write);
	}
	sem_post(sem_colisions_read);
	sem_wait(sem_colisions_write);
    cleanup();
    fclose(report);

}

