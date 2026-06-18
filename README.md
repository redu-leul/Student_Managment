## Student Record Managment System
# Project overview
This project is a student record managment system developed using java file i/o and streams. It allows users to manage student recoreds efficiently using text files,binary files and object serialization.
The system has features like file handling, exception handling, and stream processing.

## Features
# Student class contains:

- Name
- Studentid
- Department
- GPA
  
# Functions include:

- Add students
- Search students
- update students
- delete students
- display all of the students added

# Data storage methods

- Text Files (using Scanner and printwriter)
- Binary Files (using DataInputStream and DataOutputStream)
- Object serialization(using ObjectInputStream and ObjectOutputStream)
- Automatically create required directories/files
  
# Reporting Features

The system can generate statistical reports:

- Total number of students
- Student with highest GPA
- Student with lowest GPA
- Average GPA calculation

# File Management

Uses Java File class to:

- Automatically create required directories/files
- Display file information:
- File name
- File path
- File size
- Last modified date

# Backup System

Uses Buffered Streams
Creates backups of student records for safety and recovery
- Exception Handling

The system includes proper exception handling for:

- File not found errors
- Input/output errors
- Invalid data entry
- Stream-related exceptions

# System Design

The system is structured into:

- Student class → Data model
- StudentManager class → Core logic (CRUD operations)
- File handling modules → Text, binary, and serialization
- Report generator → GPA statistics
- Utility functions → Backup and file management

This project demonstrates practical use of:

Java File I/O
Streams
Object-Oriented Programming
Data persistence techniques

It provides a complete real-world simulation of a student database system.

