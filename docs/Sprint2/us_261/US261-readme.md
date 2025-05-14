# US 261 - Initiate simulation for a figure

## 1. Context

* The simulation system is designed to validate the safety and accuracy of drone formations (figures) before they are approved for execution. Each figure consists of multiple drones that follow predefined movement scripts. To ensure there are no collisions during execution, a simulation must be run where each drone's movements are tracked and analyzed in real time.

* This user story introduces the requirement to initiate a simulation process for a given figure using concurrent processes. Each drone in the figure should operate in isolation via separate child processes, while the main process manages communication, synchronization, and collision detection. The communication between processes will be handled through pipes, and signals will be used to control the lifecycle of each drone process.


## 2. Requirements

**US261** - As a system user, I want to start a simulation process for a figure so that I can check for collisions before approving it.


**Acceptance Criteria:**

- US261.1  This component must be implemented in C and must utilize processes, pipes, and signals.
- US261.2  The system should fork a new process for each drone in the figure
- US261.3  Each drone process should execute its designated movement script.
- US261.4  Pipes should facilitate communication between the main process and each drone process.
- US261.5  The main process should track drone positions over time using an appropriate data structure.

**Dependencies/References:**

* This user story does not depend on any user story.


**Forum Insight:**

>> Para a simulação dos drones, qual deve ser a resolução temporal entre atualizações de posição de cada drone? Minutos, segundos ou milissegundos?
>
> Provavelmente faz sentido que possa ser configurável pelo utilizador. Minutos é um disparate completo. Não faz qualquer sentido. Mas poucos milissegundos pode ser um exagero e ser muito pesado do ponto de vista computacional.





