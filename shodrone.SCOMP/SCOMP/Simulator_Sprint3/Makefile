projeto: ui.o simulator_sprint3.o utils.o
	gcc ui.o simulator_sprint3.o utils.o -o projeto

ui.o: ui.c simulator_sprint3.h
	gcc -g -Wall -Wextra -fanalyzer -c ui.c -o ui.o

simulator_sprint3.o: simulator_sprint3.c simulator_sprint3.h 
	gcc -g -Wall -Wextra -fanalyzer -c simulator_sprint3.c -o simulator_sprint3.o

utils.o : utils.c simulator_sprint3.h
	gcc -g -Wall -Wextra -fanalyzer -c utils.c -o utils.o
	
clean:
	rm -f *.o projeto

run: projeto
	./projeto
