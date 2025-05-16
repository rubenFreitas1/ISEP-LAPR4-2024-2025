#include <stdio.h>
#include "simulator.h"

int main() {
    char fileName[100];
	int maxCollisions;

    printf("===== DRONE SIMULATOR =====\n");
    printf("Enter the name of the CSV file: ");
    scanf("%s", fileName);
    printf("Enter the maximum number of collisions allowed: ");
    scanf("%d", &maxCollisions);

    simulator_run(fileName, maxCollisions);
    return 0;
}
