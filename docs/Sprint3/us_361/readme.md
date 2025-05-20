
# US 361

## 1. Context

*As a Drone Tech, I want to start the simulation with a multi-threaded parent process and multiple child drone processes communicating through a shared memory area, so that the system efficiently coordinates simulation data across processes.
## 2. Requirements

**US 361** As a Drone Tech, I want to start the simulation with a multi-threaded parent process and multiple child drone processes communicating through a shared memory area, so that the system efficiently coordinates simulation data across processes.
**Acceptance Criteria:**

- US361.1 The parent process spawns dedicated threads for its functionalities.
- US361.2 Each drone is launched as an independent process.
- US361.3 A shared memory segment is allocated and properly initialized for inter-process communication.
- US361.4 Drone processes are configured to use semaphores for synchronization.
- US361.5 This component must be implemented in C and must utilize threads, mutexes, condition variables, and signals.

**Dependencies/References:**

* There are no dependencies with other user stories.

**Forum Insight:**

* Still no questions related to this user story on forum.
* 

## 3. Integration/Demonstration

