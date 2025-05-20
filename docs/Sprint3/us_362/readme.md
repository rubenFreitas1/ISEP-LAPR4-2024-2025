# US 362 - Implement function-specific threads in the parent process

## 1. Context

*This user story introduces dedicated threads within the parent process to handle critical functionalities independently
and in parallel. Specifically, one thread will continuously monitor drone positions to detect collisions in shared memory,
while another will generate reports based on simulation results and collision events. These threads must operate concurrently
to avoid bottlenecks, and should be carefully synchronized using mutexes and condition variables to prevent race conditions and ensure data integrity.*

## 2. Requirements

**US362** As a PO, I want the simulation controller parent process to have at least two dedicated threads (one for collision detection and one for report generation), so that each functionality operates concurrently and independently.

**Acceptance Criteria:**

- US362.1 The parent process creates a collision detection thread responsible for scanning the shared memory for drone position conflicts.
- US362.2 A report generation thread is created to compile simulation results and respond to collision events.
- US362.3 Any additional thread that you deem appropriate for any of the required functionalities.
- US362.4 Threads are managed using mutexes and condition variables for internal synchronization.

**Dependencies/References:**

*This user story depends on US361 because for the parent process create at least 2 threads,the simulation must be started first.*

**Forum Insight:**

* Still no questions related to this user story on forum.

