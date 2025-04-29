# US 236 - Edit a show request

## 1. Context

* In the Shodrone CRM system, a show request is created by a CRM Collaborator when a customer expresses interest in scheduling a drone show. This request includes details such as customer identity, event location, date and time, tentative number of drones, duration, and a document describing the sequence of figures and exclusivity requirements.
* User Story US236 is focused on allowing CRM Collaborators to edit show requests — but strictly only those that do not yet have an associated proposal. This ensures consistency and integrity of the negotiation and proposal process, preventing retroactive changes that could impact agreed terms or design work already underway.

## 2. Requirements

**US236** - As CRM Collaborator, I want to edit a show requests of a client.

**Acceptance Criteria:**

- US230.1 The system must guarantee only show requests without a proposal can be edited.

**Dependencies/References:**

* This user story depends on user story US230 because to edit a show request the show request must already be registered in the system

**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US236.svg)

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
