# Project Planning and Technical Documentation

## 1. Group Members

The members of the group:

| Student Number  	 | Name            |
|-------------------|-----------------|
| **1231267**       | Rúben Freitas   |
| **1231031**       | Rafael Costa	   |
| **1230927**       | José Ribeiro	   |
| **1222123**       | João Sousa      |
| **1230630**       | José Alves      |

## 2. Tasks Assigned

### Sprint 1

| Task                                | [Sprint 1]() |
|-------------------------------------|--------------|
| US101 Technical constraints         | all members  |
| US102 Project repository            | all members  |
| US103 Project structure             | all members  |
| US104 Continuous integration server | all members  |
| US105 Automated deployment          | all members  |
| US110 Domain Model                  | all members  |

### Sprint 2

| Task                                                       | [Sprint 2]()      |
|------------------------------------------------------------|-------------------|
| US210 Authentication and authorization                     | all members       |
| US211 Register users                                       | all members       |
| US212 Disable/enable users                                 | all members       |
| US213 List users                                           | all members       |
| US220 Register Customer                                    | 1231031           |
| US221 Add a customer representative                        | 1231031           |
| US222 List customer representatives                        | 1231031           |
| US223 Edit a customer representative                       | 1231031           |
| US224 Disable a customer representative                    | 1230927           |
| US230 Show request                                         | 1230927           |
| US231 Figure catalogue                                     | 1230927           |
| US232 Search figure catalogue                              | 1230927           |
| US233 Add figure to the catalogue                          | 1231267           |
| US234 Decommission figure                                  | 1231267           |
| US235 List show requests of client                         | 1231267           |
| US236 Edit a show request                                  | 1230927           |
| US240 Drone model creation                                 | 1231267           |
| US241 Add drone to the inventory                           | 1231267           |
| US242 Remove drone from the inventory                      | 1222123           |
| US243 List drones in the inventory                         | 1222123           |
| US245 Add figure category                                  | 1222123           |
| US246 Edit figure category                                 | 1222123           |
| US247 List figures categories                              | 1222123           |
| US248 Inactivate/Activate a figure category                | 1231031           |
| US251 Specification of the language for figure description | 1222123 / 1230927 |
| US253 Configuration of a drone’s language                  | all members       |
| US255 Configuration of proposal templates                  | 1231031 / 1231267 |
| US261 Initiate simulation for a figure                     | all members       |
| US262 Capture and process drone movements                  | 1231267           |
| US263 Detect drone collisions in real time                 | 1231031           |
| US265 Generate a simulation report                         | 1230927           |

### Sprint 3

| Task                                                              | [Sprint 3]() |
|-------------------------------------------------------------------|--------------|
| US310 Create Show Proposal                                        | 1230927      |
| US311 Add drones to a proposal                                    | 1231267      |
| US312 Add figures to a proposal                                   | 1222123      |
| US315 Add video of simulation to the proposal                     | 1230927      |
| US316 Send show proposal to the customer                          | 1231031      |
| US317 Mark show proposal as accepted                              | 1231267      |
| US318 Templates for show proposals                                | 1231031      |
| US321 Add maintenance type                                        | all members  |
| US322 List maintenance types                                      | all members  |
| US323 Edit maintenance types                                      | all members  |
| US325 List maintenance history of a drone                         | all members  |
| US326 Add maintenance record to a drone                           | all members  |
| US327 Register drone usage time                                   | all members  |
| US328 List drones needing preventive maintenance                  | all members  |
| US340 DSL Plugin                                                  | 1230927      |
| US341 Validate figure description                                 | 1231031      |
| US345 Drone language plugin                                       | 1222123      |
| US347 Proposal generation                                         | 1231267      |
| US348 Show generation                                             | all members  |
| US361 Initialize hybrid simulation environment with shared memory | all members  |
| US362 Implement function-specific threads in the parent process   | 1231267      |
| US363 Notify report thread via condition variables upon collision | 1231031      |
| US364 Enforce step-by-step simulation synchronization             | 1222123      |
| US365 Generate and store final simulation report                  | 1230927      |
| US370 Analyse a proposal                                          | 1231267      |
| US371 Accept/reject proposal                                      | 1231031      |
| US372 Check shows dates                                           | 1222123      |
| US373 Get show info                                               | 1230927      |
| US376 Show testing                                                | all members  |
| US378 Running test                                                | 1230630      |


## 2. Team Decisions (Sprint 3)

- We divided the user stories as shown in the table on the project sheet.
- As a team with only 4 members, we have decided to focus on the user stories requested for the 4 and only when these are finished, if
time is not a problem, we would start doing the user stories meant for other 2 members (US321 to US328).
- As a team we decided to use DTOs to structure and simplify data exchange between layers of our application.
- As a team we decided that a DSL can be associated to multiple figures.
- The members Rafael and Rúben assumed that the US316 (Send Show Proposal) and US347 (Proposal Generation) implementation would be combined.

