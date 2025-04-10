# US 234 - Decommission figure

## 1. Context

*  The goal is to implement a feature that allows the CRM Manager to decommission a figure from the catalogue, 
ensuring it is no longer available for future use.


## 2. Requirements

**US234** - As CRM Manager, I want to decommission a figure from the catalogue so that it will not be used anymore.


**Acceptance Criteria:**

- US234.1 The system should make sure that the figure can not be used after being decommissioned.


**Dependencies/References:**

* This user story depends on user story US233 because to decommission a figure from the catalogue, the figure must be added first to the catalogue.


**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US234.svg)

## 4. Design

*In this sections, the team should present the solution design that was adopted to solve the requirement. This should include, at least, a diagram of the realization of the functionality (e.g., sequence diagram), a class diagram (presenting the classes that support the functionality), the identification and rational behind the applied design patterns and the specification of the main tests used to validade the functionality.*

### 4.1. Realization

![a class diagram](images/class-diagram-01.svg "A Class Diagram")

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
