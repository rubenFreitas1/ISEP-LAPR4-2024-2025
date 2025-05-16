# US 264 - Synchronize drone execution with a time step

## 1. Context

* The goal is to synchronize drone movements using fixed time steps. The simulation should wait for all drones to report 
their positions before progressing to the next step. This ensures accurate coordination, collision checks, and time-based analysis. This feature builds on US262, which enables the system to receive and track drone movements

## 2. Requirements

**US264** - As a simulation engine, I want to synchronize drone movements based on time steps So that I can accurately simulate real-world execution.


**Acceptance Criteria:**

- US264.1  The simulation must progress step by step.

- US264.2  Each drone process should send position updates at defined intervals.

- US264.3  The main process must ensure all updates for a given time step are processed before advancing to the next step.

**Dependencies/References:**

* This user story depends on US262 because of the capture and process drone movements you have to start a simulation.


**Forum Insight:**

* There is no forum insight for this user story.