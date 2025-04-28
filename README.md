# Task-management-system-
This is a **Task Management System** built using **Spring Boot**, **Spring Data JPA**, and **H2 Database** for development. It supports operations for managing users and tasks, such as creating tasks, assigning tasks, and retrieving tasks by creator or assignee. The system also supports task status updates.

## Technologies Used:
- **Java 17** (or higher)
- **Spring Boot 2.x**
- **Spring Data JPA**
- **H2 Database** (in-memory for development)
- **REST API** for interaction
- **Maven** for dependency management

## Project Structure:
- **Controller Layer**: Exposes REST API endpoints to interact with users and tasks.
- **Service Layer**: Contains business logic to handle operations such as task creation and user management.
- **Repository Layer**: Handles database interactions using Spring Data JPA.
- **Entity Layer**: Contains the core data models (User, Task).
- **DTO Layer** (Optional for future): Can be used to manage input and output data more efficiently.

## Features Implemented:
1. **User Management:**
   - Create a user.
   - Get all users.
   - Get a user by ID or email.
   - Delete a user.

2. **Task Management:**
   - Create a task.
   - Assign a task to a user.
   - Fetch tasks by creator.
   - Fetch tasks by assignee.
   - Filter tasks by status (e.g., `PENDING`, `IN_PROGRESS`, `COMPLETED`).

## API Endpoints:

### User Endpoints:
- `POST /api/users`: Create a new user.
- `GET /api/users`: Get all users.
- `GET /api/users/{id}`: Get a user by ID.
- `GET /api/users/by-email?email={email}`: Get a user by email.
- `DELETE /api/users/{id}`: Delete a user by ID.

### Task Endpoints:
- `POST /api/tasks`: Create a new task.
- `GET /api/tasks`: Get all tasks.
- `GET /api/tasks/{id}`: Get a task by ID.
- `GET /api/tasks/creator/{creatorId}`: Get tasks created by a specific user.
- `GET /api/tasks/assignee/{assigneeId}`: Get tasks assigned to a specific user.
- `GET /api/tasks/status?status={status}`: Get tasks by their status (e.g., `PENDING`, `IN_PROGRESS`, `COMPLETED`).
- `DELETE /api/tasks/{id}`: Delete a task by ID.

## Database:
For the development environment, this project uses an in-memory **H2 Database**.

- **H2 Console**: You can view the H2 console at `http://localhost:8080/h2-console` (configured by default).

### Database Entities:
- **User Entity**: Represents a user in the system (name, email, role).
- **Task Entity**: Represents a task (title, description, creator, assignee, status).

## How to Run the Project:

### Prerequisites:
- **JDK 17+** installed on your system.
- **Maven** for building and managing the project.

### Steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/task-manager.git
   cd task-manager
