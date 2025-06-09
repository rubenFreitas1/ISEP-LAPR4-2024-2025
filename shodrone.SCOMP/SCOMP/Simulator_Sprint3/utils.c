#include "simulator_sprint3.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//MÉTODO QUE RETIRA A INFORMAÇÃO TODA DO CSV E COLOCA NUM DroneData GERAL
int readCsv(const char* fileName, DroneData** data, int* totalDrones) {
    FILE* fp = fopen(fileName, "r");
    if (!fp) {
        perror("Erro ao abrir o ficheiro");
        return 0;
    }

    char line[256];

    if (fgets(line, sizeof(line), fp) == NULL) {
        fclose(fp);
        return 0;
    }

    char* token = strtok(line, ",\n\r");
    
    if (token != NULL && token[0] == '\xEF' && token[1] == '\xBB' && token[2] == '\xBF') {
		token += 3; 		// avança o ponteiro para ignorar os 3 bytes do BOM (Byte Order Mark) que é automaticamente criado por excel
	}
	
    if (token != NULL) {
        *totalDrones = atoi(token);
    } else {
        fclose(fp);
        return 0;
    }

    if (fgets(line, sizeof(line), fp) == NULL) {
        fclose(fp);
        return 0;
    }

    int capacity = 5;
    int count = 0;
    *data = malloc(capacity * sizeof(DroneData));
    if (!(*data)) {
        fclose(fp);
        return 0;
    }

    while (fgets(line, sizeof(line), fp)) {
        if (count >= capacity) {
            capacity += 5;
            DroneData* temp = realloc(*data, capacity * sizeof(DroneData));
            if (!temp) {
                free(*data);
                fclose(fp);
                return 0;
            }
            *data = temp;
        }

        DroneData d;
        if (sscanf(line, "%d,%f,%f,%f,%d", &d.droneID, &d.x, &d.y, &d.z, &d.timestamp) == 5) {
            (*data)[count++] = d;
        }
    }

    fclose(fp);
    return count;
}


//MÉTODO QUE AJUDA A VISUALIZAR A INFORMAÇÃO DAS POSIÇÕES DE CADA DRONE
//USADO PARA TESTAR E CONFIRMAR INFORMAÇÕES
void printDroneData(int droneID, DroneData* droneData, int dronePositions) {
    printf("[DRONE %d] Tem %d posições\n", droneID, dronePositions);
    for (int k = 0; k < dronePositions; ++k) {
        printf("  -> Pos: (%.2f, %.2f, %.2f), tempo: %d\n",
               droneData[k].x, droneData[k].y, droneData[k].z, droneData[k].timestamp);
    }
}


//MÉTODO QUE AJUDA A VISUALIZAR TODOS OS TIMESTAMPS UNICOS DA FIGURA
void printTimestamps(int* timestamps, int count) {
    printf("Timestamps únicos (%d):\n", count);
    for (int i = 0; i < count; ++i) {
        printf("  -> %d\n", timestamps[i]);
    }
}

// MÉTODO PARA DAR DISPLAY AS INFORMAÇÕES GERAIS DA FIGURA COMO POR EXEMPLO O NUMERO DE DRONES E AS POSIÇOES DE CADA UM AO LONGO DO TEMPO
void simulator_info(DroneData* data, int totalPositions, int totalDrones) {
    if (totalPositions > 0) {
        printf("Total de Drones: %d\n", totalDrones);
        printf("Total de Posições: %d\n", totalPositions);

        for (int i = 0; i < totalPositions; ++i) {
            printf("Drone %d: (%.2f, %.2f, %.2f), tempo: %d\n",
                   data[i].droneID, data[i].x, data[i].y, data[i].z, data[i].timestamp);
        }
    } else {
        printf("Falha ao ler o ficheiro.\n");
    }
}



//MÉTODO PARA DAR SORT NOS TIMESTAMPS DO MENOR PARA O MAIOR
void bubbleSort(int* arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
        }
    }
}

// MÉTODO QUE ESCREVE O CABEÇALHO INICIAL DO RELATÓRIO
// INCLUI O NÚMERO TOTAL DE DRONES E A SECÇÃO DE COLISÕES
void writeHeader(FILE* report, int totalDrones) {
    fprintf(report, "=== Simulation Report ===\n");
    fprintf(report, "Total Drones: %d\n\n", totalDrones);
    fprintf(report, "--- Collisions ---\n");
}

// MÉTODO QUE REGISTA UMA COLISÃO NO RELATÓRIO
// INCLUI O TIMESTAMP, A POSIÇÃO DA COLISÃO E OS DRONES ENVOLVIDOS
void logCollision(FILE* report, int timestamp, float x, float y, float z, int drone1, int drone2, float x1, float y1, float z1) {
    fprintf(report, "[COLLISION] Timestamp: %ds | Position: (%.2f, %.2f, %.2f) | Drones involved: %d and %d\n",
            timestamp, x, y, z, drone1, drone2);
    fprintf(report, "Drone %d moved to position: (%.2f, %.2f, %.2f)\n\n", drone1, x1, y1, z1);
}

// MÉTODO QUE ESCREVE O RESULTADO FINAL DA SIMULAÇÃO NO RELATÓRIO
// INDICA SE A SIMULAÇÃO FOI BEM-SUCEDIDA (PASSED) OU SE FALHOU (FAILED)
void writeValidationStatus(FILE* report, int passed) {
    fprintf(report, "\n--- Validation ---\n");
    fprintf(report, "Simulation %s\n", passed ? "PASSED" : "FAILED");
}

// MÉTODO QUE ESCREVE O ESTADO FINAL DE EXECUÇÃO DOS DRONES NO RELATÓRIO
// INDICA SE O EXECUTION STATUS É FINISHED OU ABORTED
void writeExecutionStatus(FILE* report, int collisions, int totalDrones, DroneData* shared_struct_list, int passed) {
	if (collisions == 0) {
		fprintf(report, "No collisions occurred during the simulation.\n");
	}
    fprintf(report, "--- Drone Execution Status ---\n");
    if (collisions == 0) {
        fprintf(report, "All drones: FINISHED\n");
    } else {
		for (int i = 0; i < totalDrones; i++) {
			const DroneData *d = &shared_struct_list[i];

			if (d->collisions == 0) {
				fprintf(report, "Drone %d: %s", d->droneID, passed ? "FINISHED\n" : "ABORTED\n");
			} else {
				fprintf(report, "Drone %d: ABORTED – %d collision%s\n", d->droneID, d->collisions, d->collisions == 1 ? "" : "s");
			}
		}
    }
}

// MÉTODO QUE RETIRA O NOME BASE DO FICHEIRO A PARTIR DO CAMINHO
void getBaseName(const char *filePath, char *baseName) {
    const char *lastSlash = strrchr(filePath, '/');
    const char *fileName = lastSlash ? lastSlash + 1 : filePath;

    const char *lastDot = strrchr(fileName, '.');
    if (lastDot) {
        strncpy(baseName, fileName, lastDot - fileName);
        baseName[lastDot - fileName] = '\0';
    } else {
        strcpy(baseName, fileName);
    }
}

void intToStr(int num, char* str) {
    snprintf(str, 12, "%d", num);
}

