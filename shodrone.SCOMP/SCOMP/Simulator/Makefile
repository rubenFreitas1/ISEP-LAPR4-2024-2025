CC = gcc
CFLAGS = -g -Wall -Wextra
OBJS = ui.o simulator.o utils.o

projeto: $(OBJS)
	$(CC) $(OBJS) -o projeto

ui.o: ui.c simulator.h
	$(CC) $(CFLAGS) -c ui.c

simulator.o: simulator.c simulator.h
	$(CC) $(CFLAGS) -c simulator.c

utils.o: utils.c
	$(CC) $(CFLAGS) -c utils.c

run: projeto
	./projeto exemplo1.csv 5

clean:
	rm -f *.o projeto