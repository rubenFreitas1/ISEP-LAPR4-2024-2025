# Project Shodrone

## 1. Description of the Project

Project Shodrone is an autonomous drone control and operation system designed for various applications, including security, industrial inspection, and environmental monitoring. The project aims to develop a reliable and efficient platform for managing multiple drones simultaneously with minimal human intervention.
This project was developed in a SCRUM-based agile process over 3 sprints.

## 🛠️ Technologies Used

- Java - Main application, servers

- C - Drone Simulator  (process/thread management)

- ANTLR4 - Grammar definition and parsing for templates

- TCP Sockets - Inter-server and client-server communication

- H2 Database - In-memory storage with JPA

- JPA - ORM + repository layer for data persistence


## 📌 Best Practices and Design Highlights

- The project followed an iterative and incremental development model (SCRUM-based), with 3 sprints.
- Domain Modeling
- Applied *Object-Oriented Programming (OOP)* principles and layered design
- Concurrency in C: Advanced synchronization mechanisms implemented (semaphores, mutexes, condition variables).
- Encapsulation: Use of DTOs to isolate internal domain logic.
- ANTLR & Visitor pattern: Clean parsing and templating logic.

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Clean

To clean the project execute the script (only for windows):

    ./mvn-clean.bat

To clean the project execute the script (only for linux/unix/macos):

    ./mvn-clean.sh

## 4. How to Build

To build the project execute the script (only for windows):

    ./build-all.bat

To build the project execute the script (only for linux/unix/macos):

    ./build-all.sh

To quick build the project execute the script (only for windows):

    ./quickbuild.bat

To quick build the project execute the script (only for linux/unix/macos):

    ./quickbuild.sh

## 5. How to Execute Tests

To run all the tests execute the script (only for windows):

    ./run-tests.bat

To run all the tests execute the script (only for linux/unix/macos):

    ./run-tests.sh



