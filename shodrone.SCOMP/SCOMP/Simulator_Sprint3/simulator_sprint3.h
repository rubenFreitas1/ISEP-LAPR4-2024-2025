
#ifndef SIMULATOR_SPRINT3_H
#define SIMULATOR__SPRINT3_H
#include <stdio.h>


typedef struct {
    int droneID;
    float x;
    float y;
    float z;
    int timestamp;
} DroneData;

typedef struct{
	int timestamp;
	DroneData* drone_positions;
}shared_positions;

typedef struct{
	int hitDroneID;
	DroneData collisionDrone;
	DroneData realocatedDrone;
	int maxcollisions;
}report_info;

typedef struct {
    int* pids;
    int totalDrones;
    int maxCollisions;
} ThreadArgs;


typedef struct {
    int droneID;
    int timestamp;
} MatrixCellInfo;

#define MAX_X 80
#define MAX_Y 80
#define MAX_Z 80
#define STR_SIZE 150

void simulator_run(const char* fileName, int maxCollisions);
int readCsv(const char* fileName, DroneData** data, int* totalDrones);
void printDroneData(int droneID, DroneData* droneData, int dronePositions);
void printTimestamps(int* timestamps, int count);
void bubbleSort(int* arr, int n);
void simulator_info(DroneData* data, int totalPositions, int totalDrones);
void int_to_str(int value, char *str);
void writeHeader(FILE* report, int totalDrones);
void logCollision(FILE* report, int timestamp, float x, float y, float z, int drone1, int drone2, float x1, float y1, float z1);
void writeValidationStatus(FILE* report, int passed);
void writeExecutionStatus(FILE* report, int statuses, int collisions);
void getBaseName(const char *filePath, char *baseName);
void intToStr(int num, char* str);

#endif
