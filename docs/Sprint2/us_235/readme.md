# US 235 - List show requests of client

## 1. Context

* This functionality helps CRM users track client engagement, follow up on ongoing or past requests, and ensure a high level of customer service.
Therefore, a feature to list all show requests associated with a client, including their current status, is essential for efficient and informed client management.

## 2. Requirements

**US235** - As CRM Manager or CRM Collaborator, I want to list all show requests of a client.
The show request status information should be provided.


**Acceptance Criteria:**

- US235.1 When the list is displayed, each request must include its current status.

- US235.2 Given a client with no show requests, a message should be displayed indicating that no requests were related to that client.


**Dependencies/References:**

* This user story depends on US230 because to list the show requests, the CRM Collaborator must register them in the system before.

**Forum Insight:**

* Still no questions related to this user story on forum.


## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US235.svg )


## 4. Design


### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US235.svg)

### 4.3. Applied Patterns

- Domain-Driven Design
- Factory

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

