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

#define MAX_X 100
#define MAX_Y 100
#define MAX_Z 100

void simulator_run(const char* fileName);
int readCsv(const char* fileName, DroneData** data, int* totalDrones);
void printDroneData(int droneID, DroneData* droneData, int dronePositions);
void printTimestamps(int* timestamps, int count);
void bubbleSort(int* arr, int n);
void simulator_info(DroneData* data, int totalPositions, int totalDrones);

#endif
