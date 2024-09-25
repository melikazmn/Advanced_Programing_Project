# Management System

## Overview

This project is a management system implemented in Java that facilitates interaction between managers, professors, and students. The system allows for managing lessons, exams, and grades through a user-friendly GUI utilizing JOptionPane.

## Features

- **Manager Functionality**:
  - Add professors, students, terms, and lessons.
    
- **Professor Functionality**:
  - Choose lessons to teach.
  - Add exams for chosen lessons.
  - Review student inquiries regarding their grades and adjust grades if necessary.
    
- **Student Functionality**:
  - Sign up for lessons in each term.
  - Take exams for enrolled lessons and receive grades.
  - Send messages to professors regarding their grades.
  - View all of their grades.
  - Getting Started

## Prerequisites

To run this project, you need to have:
- Java Development Kit (JDK) installed on your machine.
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse).

## Code Structure

- **Main.java**: Entry point of the application where the user is prompted to log in.
- **User Classes**: Contains classes for User, Professor, Student, Management, Term, and Lesson that define attributes and methods for each role.
- **JOptionPane**: Utilized for displaying GUI dialogs for user interactions.
