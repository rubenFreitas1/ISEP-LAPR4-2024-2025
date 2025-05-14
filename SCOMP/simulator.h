#ifndef SIMULATOR_H
#define SIMULATOR_H
#include <stdio.h>


typedef struct {
    int droneID;
    float x;
    float y;
    float z;
    int timestamp;
} DroneData;


typedef struct {
    int droneID;
    int timestamp;
} MatrixCellInfo;

#define MAX_X 80
#define MAX_Y 80
#define MAX_Z 80

void simulator_run(const char* fileName, int maxCollisions);
int readCsv(const char* fileName, DroneData** data, int* totalDrones);
void printDroneData(int droneID, DroneData* droneData, int dronePositions);
void printTimestamps(int* timestamps, int count);
void bubbleSort(int* arr, int n);
void simulator_info(DroneData* data, int totalPositions, int totalDrones);
void int_to_str(int value, char *str);
void writeHeader(FILE* report, int totalDrones);
void logCollision(FILE* report, int timestamp, float x, float y, float z, int drone1, int drone2);
void writeValidationStatus(FILE* report, int passed);
void writeExecutionStatus(FILE* report, int statuses, int collisions);
void getBaseName(const char *filePath, char *baseName);

#endif
