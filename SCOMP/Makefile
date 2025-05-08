projeto: ui.o simulator.o utils.o
	gcc ui.o simulator.o utils.o -o projeto

ui.o: ui.c simulator.h
	gcc -g -Wall -Wextra -fanalyzer -c ui.c -o ui.o

simulator.o: simulator.c simulator.h 
	gcc -g -Wall -Wextra -fanalyzer -c simulator.c -o simulator.o

utils.o : utils.c simulator.h
	gcc -g -Wall -Wextra -fanalyzer -c utils.c -o utils.o
	
clean:
	rm -f *.o projeto

run: projeto
	./projeto
