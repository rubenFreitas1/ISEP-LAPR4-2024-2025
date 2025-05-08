#include <stdio.h>
#include "simulator.h"

int main() {
    char fileName[100];

    printf("===== DRONE SIMULATOR =====\n");
    printf("Enter the name of the CSV file: ");
    scanf("%s", fileName);

    simulator_run(fileName);
    return 0;
}
