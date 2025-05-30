# US 365 - Generate and store final simulation report

## 1. Context

* This user story focuses on the generation and storage of a comprehensive final report once the drone simulation
concludes. The report serves as a key artifact for assessing the simulation's success by summarizing drone behavior,
execution outcomes, and safety-related incidents such as collisions. After the simulation ends, a dedicated thread is
responsible for aggregating all relevant data from the shared memory, including drone statuses and any collision events
(with their timestamps and coordinates). The report must also provide a clear overall validation result (pass/fail) and
be saved persistently for post-simulation analysis or auditing.

## 2. Requirements

**US 365** As a Drone tech, I want a comprehensive report that details the simulation outcomes — including 
drone execution statuses, collision events (with timestamps and positions), and overall validation
results —, so that I can assess the safety and performance of the figure post-simulation.


**Acceptance Criteria:**

- US365.1 The report generation thread aggregates data from the shared memory once the simulation concludes.
- US365.2 The report includes the total number of drones, individual execution statuses, and detailed collision events.
- US365.3 The final validation result (pass/fail) is clearly indicated.
- US365.4 The complete report is saved to a file for future reference.

**Dependencies/References:**

*There is a dependency with US361, US362, US363, US364, because to make the report the simulator needs to be running correctly and this US ensure that.*


**Forum Insight:**

* Still no questions related to this user story on forum.
