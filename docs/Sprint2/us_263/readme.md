
# US 263

## 1. Context

*As a simulation system, I want to continuously monitor drone positions for overlaps so that I can identify and report collisions.*

### 1.1 List of issues

Analysis:

Design:

Implement:

Test:


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

## 3. Analysis

*In this section, the team should report the study/analysis/comparison that was done in order to take the best design decisions for the requirement. This section should also include supporting diagrams/artifacts (such as domain model; use case diagrams, etc.),*

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

![a class diagram](class-diagram-01.svg "A Class Diagram")

### 4.3. Applied Patterns

### 4.4. Acceptance Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria. May be automated or manual tests.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** US101.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*
```
