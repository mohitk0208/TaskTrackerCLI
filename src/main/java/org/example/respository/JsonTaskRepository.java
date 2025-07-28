package org.example.respository;

import org.example.models.Task;

import java.util.List;
import java.util.Optional;

public class JsonTaskRepository implements TaskRepository{
    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Task> findByStatus(String status) {
        return List.of();
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }
}
