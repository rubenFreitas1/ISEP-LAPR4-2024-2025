# US 101

## 1. Context

This task asks us to ensure that the team follows the technical constraints and concerns of the project. These 
constraints and concerns are described in section 5.

## 2. Requirements

>- **Project Management using scrum:** Scrum should be used for project management. The group’s LAPR4 PL teacher will be the Scrum Master
and there will be one weekly scrum meeting with the scrum Master during the LAPR4 PL+OT class.
The Development Process document, available at Moodle, provides detailed information regarding this requirement.

>- **Technical Documentation:** Maintain documentation in the project's "docs" folder in Markdown format, using UML notation where applicable. Documentation should cover every development phase of a User Story (analysis, design, testing, etc.).
The diagrams’ source files and the actual diagrams in a vector format (PNG) must be included in the repository.

>- **Test-driven Development:** Implement a comprehensive set of automated tests for each User Story/Class/Method, aiming for a test-driven development approach.

>- **Source Control:** Version all source code, documentation, and related artifacts in a provided GitHub repository, using only the main (master/main) branch for releases.

>- **Continuous Integration:** The GitHub repository should support nightly builds, with published results and metrics.

>- **Deployment and Scripts:** Include necessary scripts for building and deploying the solution on Linux and Windows systems, along with a readme.md file explaining the build, deployment, and execution processes.

>- **Database:** Support data persistence both "in memory" and in a relational database (RDBMS), with the final deployment using a persistent RDB. The system should also be able to initialize default data.

>- **Authentication and Authorization:** Implement and enforce authentication and authorization for all users and functionalities.

>- **Network sockets APIs:** The network sockets APIs may either implement a new application protocol developed for this purpose
or use an existing standard application protocol, like HTTP.

>- **High-level language (DSL) and drones’ language analysis/validation:** The support for this functionality must follow specific technical requirements provided in LPROG. The
   ANTLR tool should be used.

>- **Simulation system in sprint 3:** Shodrone wants the simulation system to use a multithreaded parent process and child drone
processes communicating via shared memory, with functionalities separated into dedicated threads (collision detection and report generation), so that the simulation runs step-by-step with robust
synchronization using semaphores and can be terminated via signals when a collision threshold is exceeded.

## 3. Analysis

There are no specific analysis details for this user story.

## 4. Design

There are no specific design details for this user story.

## 5. Implementation

There are no specific implementation for this user story. 