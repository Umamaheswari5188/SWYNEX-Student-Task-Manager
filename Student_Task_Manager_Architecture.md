# SWYNEX Internship -- Task 1

# Project Architecture Document

**Project title:** Student Task Manager\
**Repository name:** SWYNEX-Student-Task-Manager\
**Project type:** Full-stack web application

## 1. Introduction

The Student Task Manager is a web-based application designed to help
students organize and manage daily academic activities. Students can
create tasks, manage assignments, set deadlines, update task details,
and track completed activities.

## 2. Problem Statement

Students often find it difficult to manage multiple assignments, study
schedules, and daily activities. This application provides a centralized
platform to organize academic tasks and monitor their completion status.

## 3. Objectives

-   Provide student registration and login.
-   Allow students to create and manage tasks.
-   Store task information in a database.
-   Track pending and completed tasks.
-   Provide an easy-to-use interface.
-   Support better time management and productivity.

## 4. Technology Stack

  Technology       Purpose
  ---------------- ------------------------
  HTML5            Frontend structure
  CSS3             User interface design
  JavaScript       Frontend functionality
  Java             Backend programming
  Spring Boot      REST API development
  MySQL            Database management
  Git and GitHub   Version control

## 5. System Architecture

The application follows a three-layer architecture.

-   **Presentation layer:** HTML, CSS, JavaScript, and student
    dashboard.
-   **Application layer:** Java, Spring Boot, REST APIs, and business
    logic.
-   **Data layer:** MySQL database containing student and task
    information.

**Application flow:** Student → Frontend → REST API → Backend → MySQL
Database. The backend returns a response that the frontend displays to
the student.

## 6. Data Models

### Student

  Field           Data type      Description
  --------------- -------------- -----------------------
  student_id      INT            Primary key
  name            VARCHAR(100)   Student name
  email           VARCHAR(100)   Student email; unique
  password_hash   VARCHAR(255)   Secure password hash

### Task

  Field         Data type      Description
  ------------- -------------- ---------------------------------
  task_id       INT            Primary key
  student_id    INT            Foreign key referencing Student
  title         VARCHAR(150)   Task title
  description   TEXT           Task details
  due_date      DATE           Task deadline
  status        VARCHAR(20)    Pending or Completed
  created_at    TIMESTAMP      Creation date and time

**Relationship:** One student can own many tasks (one-to-many). Each
task belongs to one student.

## 7. API Routes

  Method   Endpoint                   Purpose
  -------- -------------------------- ----------------------------------------------
  POST     `/api/auth/register`       Register a student
  POST     `/api/auth/login`          Authenticate a student
  GET      `/api/tasks`               Get tasks belonging to the signed-in student
  POST     `/api/tasks`               Create a task
  GET      `/api/tasks/{id}`          Get one task
  PUT      `/api/tasks/{id}`          Update a task
  DELETE   `/api/tasks/{id}`          Delete a task
  PATCH    `/api/tasks/{id}/status`   Update task status

All task endpoints must verify authentication and ownership so that a
student can access only their own tasks.

## 8. Frontend Screens

1.  **Registration page:** Name, email, password, and register button.
2.  **Login page:** Email, password, and login button.
3.  **Dashboard:** Welcome message and total, pending, and completed
    task counts.
4.  **Add/Edit Task page:** Task title, description, due date, and save
    button.
5.  **Tasks page:** Task list, details, edit/delete actions, and
    completion status.
6.  **Profile page:** Student information and logout option.

## 9. Functional Requirements

1.  Students can register and log in.
2.  Students can add new tasks.
3.  Students can view their tasks.
4.  Students can update task information.
5.  Students can delete tasks.
6.  Students can mark tasks as completed.
7.  Students can view pending and completed tasks.

## 10. Non-Functional Requirements

-   User-friendly and responsive interface.
-   Secure authentication and authorization.
-   Reliable database storage.
-   Input validation.
-   Maintainable code and reasonable performance.

## 11. Security Considerations

-   Store passwords using a secure password-hashing algorithm; never
    store plain-text passwords.
-   Require authentication for protected endpoints.
-   Check task ownership on every task operation.
-   Validate and sanitize user input.
-   Do not commit passwords, API keys, or other secrets to GitHub.

## 12. Conclusion

The Student Task Manager provides a simple way for students to create,
organize, and track academic tasks. The proposed architecture combines a
browser-based frontend, a Java Spring Boot backend, and a MySQL
database. Future improvements may include reminders, calendar
integration, and task priorities.

------------------------------------------------------------------------

**Prepared for:** SWYNEX Internship\
**Task:** 1 -- Project Architecture
