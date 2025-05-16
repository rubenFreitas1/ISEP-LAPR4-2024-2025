
# US 263 - Detect Drone Collisions

## 1. Context

*As a simulation system, I want to continuously monitor drone positions for overlaps so that I can identify and report collisions.*

## 2. Requirements

**US G263** As a simulation system, I want to continuously monitor drone positions for overlaps so that I can identify and report collisions.

**Acceptance Criteria:**

- US263.1 The system must detect when two or more drones occupy the same position at the same time.

- US263.2 Upon detecting a collision, the system should log the event and notify the involved drones via signals.

- US263.3 Each drone must handle the received signal and notify the system user with a message.

- US263.4 When a drone receives a SIGUSR1 (collision detected), it should block other signals while handling it.

- US263.5 The system should allow early termination if collisions exceed a predefined threshold by sending termination signals to drones.


**Dependencies/References:**

*There is a dependency with US220, since the costumer must exist so it's information can be edited.*

**Forum Insight:**

* Still no questions related to this user story on forum.
