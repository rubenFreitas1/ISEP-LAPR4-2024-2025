# US 224 -  Disable a customer representative


## 1. Context

* The US224 introduces a functionality that allows a CRM Collaborator to disable a customer representative to prevent further contact.

## 2. Requirements

**US224** - As a CRM Collaborator, I want to disable a customer representative so that they are not contacted in
29 the future.

**Acceptance Criteria:**

- US244.1 The system must guarantee that there is a customer registered
- US224.2 The system must detect if a customer is already disabled 
- US224.3 The system must guarantee that the customer gets disabled

**Dependencies/References:**

* This user story depends on user story US220 because to disable a customer representative there must be a customer in the system already

**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US224.svg)

## 4. Design


### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US224.svg)

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

