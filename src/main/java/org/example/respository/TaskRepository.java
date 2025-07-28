package org.example.respository;

import org.example.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(String id);
    Task save(Task task);
    void deleteById(String id);
    List<Task> findByStatus(String status);
    boolean existsById(String id);
}
