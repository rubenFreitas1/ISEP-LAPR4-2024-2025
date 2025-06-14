#include <stdio.h>
#include <stdlib.h>
#include "simulator.h"

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Uso incorreto! Exemplo: %s <ficheiro.csv> <collision_threshold>\n", argv[0]);
        return 1;
    }
    char* filePath = argv[1];
    int threshold = atoi(argv[2]);
    printf("Ficheiro recebido: %s\n", filePath);
    printf("Threshold recebido: %d\n", threshold);
    FILE *f = fopen(filePath, "r");
        if (!f) {
            fprintf(stderr, "Não consegui abrir o ficheiro '%s'\n", filePath);
            return 1;
        }
    fclose(f);
    printf("========== INÍCIO DA SIMULAÇÃO ==========\n");
    simulator_run(filePath,threshold);
    printf("========== SAIDA DA SIMULAÇÃO ==========\n");

    return 0;
}
