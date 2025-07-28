# Task Tracker CLI
This is a solution for problem ["Task Tracker"](https://roadmap.sh/projects/task-tracker) from [roadmap.sh](https://roadmap.sh)  

This is a simple command-line application for managing tasks. It allows you to add, remove, and list tasks.

## Features
- Add tasks with a description
- Remove tasks by ID
- List all tasks with their IDs and descriptions
- Mark tasks as completed
- Filter tasks by completion status
- Update task descriptions


## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/mohitk0208/TaskTrackerCLI
    cd TaskTrackerCLI
    ```
2. Run the application:
    ```bash
   java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar <command> <args>
    ```

## Usage
- To add a task:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar add "Task description"
  ```
- To remove a task:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar delete <task_id>
  ```
- To list all tasks:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar list
  ```
- To mark a task as completed:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar mark-done <task_id>
    ```
- To filter tasks by completion status:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar list <status>
    ```
- To update a task description:
- ```bash
  java -jar target/TaskTrackerCLI-1.0-SNAPSHOT.jar update <task_id> "New description"
    ```
