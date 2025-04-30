# US 101 - Search figure catalogue

## 1. Context

* This user story introduces a search functionality to the figure catalogue, allowing CRM Collaborators to filter figures by category and/or keyword.

## 2. Requirements

**US232** - As CRM Collaborator, I want to search the figure catalogue by category and/or keyword.
The search should ignore accents and shouldn’t be case sensitive.

**Acceptance Criteria:**

- US232.2 The system should guarantee there are figures available in the catalogue before the search
- US232.2 The search should ignore accents and shouldn’t be case sensitive.

**Dependencies/References:**

* There are no dependencies related to this user story

**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Analysis

![System Sequence Diagram](images/system-sequence-diagram-US232.svg)

## 4. Design


### 4.1. Sequence Diagram

![Sequence Diagram](images/sequence-diagram-US232.svg)

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
