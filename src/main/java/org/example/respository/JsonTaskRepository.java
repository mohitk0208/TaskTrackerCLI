package org.example.respository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.enums.TaskStatus;
import org.example.models.Task;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class JsonTaskRepository implements TaskRepository {
    private final File databaseFile;
    private final ObjectMapper objectMapper;

    public JsonTaskRepository(String filePath) {
        this.databaseFile = new File(filePath);
        this.objectMapper = new ObjectMapper();

        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Ensure the file exists
        try {
            if (!databaseFile.exists()) {
                boolean _ = databaseFile.createNewFile();
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not create database file", e);
        }

    }

    @Override
    public List<Task> findAll() {
        if (!databaseFile.exists() || databaseFile.length() == 0) {
            return List.of(); // Return an empty list if the file does not exist or is empty
        }

        try {
            return objectMapper.readValue(databaseFile, new TypeReference<>() {
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return List.of();
        }
    }

    @Override
    public Optional<Task> findById(String id) {
        List<Task> tasks = findAll();
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    @Override
    public Task save(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }

        if (existsById(task.getId())) {
            List<Task> tasks = findAll();
            tasks.removeIf(existingTask -> existingTask.getId().equals(task.getId()));
            tasks.add(task);
            writeContentsToFile(tasks);
            System.out.println("Task with id " + task.getId() + " updated successfully.");
            return task;
        } else {
            List<Task> tasks = findAll();
            tasks.add(task);
            writeContentsToFile(tasks);
            System.out.println("Task with id " + task.getId() + " created successfully.");
            return task;
        }

    }

    @Override
    public void deleteById(String id) {
        if (existsById(id)) {
            List<Task> tasks = findAll();
            tasks.removeIf(task -> task.getId().equals(id));
            writeContentsToFile(tasks);
            System.out.println("Task with id " + id + " deleted successfully.");
        } else {
            System.out.println("Task with id " + id + " not found.");
        }
    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return findAll().stream()
                .filter(task -> task.getStatus() == status)
                .toList();
    }

    @Override
    public boolean existsById(String id) {
        return findAll().stream()
                .anyMatch(task -> task.getId().equals(id));
    }

    private void writeContentsToFile(List<Task> tasks) {
        try {
            objectMapper.writeValue(databaseFile, tasks);
        } catch (Exception e) {
            throw new RuntimeException("Could not write to database file", e);
        }
    }
}
