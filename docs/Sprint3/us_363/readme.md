
# US 363

## 1. Context

*As a PO, I want the simulation system collision detection thread to notify the report generation thread through condition variables when a collision occurs, so that the report is updated in real time with accurate collision information.*
## 2. Requirements

**US 363** As CRM, I Want to register a customer.

**Acceptance Criteria:**

- US363.1 The collision detection thread monitors the shared memory for overlapping drone positions.
- US363.2 Upon detecting a collision, the thread signals the report generation thread using condition variables.
- US363.3 The report generation thread, waiting on the condition variable, immediately processes the collision event and logs it.
- US363.4 Proper mutex locking is used to ensure thread-safe notification.

**Dependencies/References:**

*There is a dependency with US361, since a hybrid simulation need to exist.*


**Forum Insight:**

* Still no questions related to this user story on forum.

## 3. Integration/Demonstration

