package org.example.service;

import org.example.models.Task;

import java.util.List;

public interface TaskService {
    Task createTask(String description);
    Task getTaskById(String id);
    Task updateTaskDescription(String id, String description);
    Task updateTaskStatus(String id, String status);
    void deleteTask(String id);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(String status);
}
