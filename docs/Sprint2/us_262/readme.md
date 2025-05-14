# US 262 - Capture and process drone movements

## 1. Context

* The purpose is to enable the simulation process to receive movement commands sent by drone scripts, allowing it to track the real-time or simulated positions of drones. 
This functionality is essential for accurately representing drone behavior during simulations,
supporting features such as path tracking, collision detection, and performance evaluation.

## 2. Requirements

**US262** - As a simulation process, I want to receive movement commands from drone scripts so that I can track
drone positions over time.


**Acceptance Criteria:**

- US262.1  Each drone process must send position updates to the main process via a pipe.

- US262.2  The main process should maintain a time-indexed 3D matrix to track drone positions.

- US262.3 The system must store past positions to anticipate and detect potential collisions.

**Dependencies/References:**

* This user story depends on US261 because to capture and process drone movements you have to start a simulation.


**Forum Insight:**

>> Boa tarde, tenho uma dúvida, quando o cliente diz "The system must store past positions to anticipate and detect potential collisions." é suposto fazer alguma coisa com essa informação, como sugerir ao utilizador a alteração da rota do drone ou é só preciso deixar no log que foi detetada?
>
> Fico com ideia que a deteção de colisões é na US263, mas pode esclarecer o assunto junto do seu docente de aulas PL de SCOMP ou junto do RUC de SCOMP.

