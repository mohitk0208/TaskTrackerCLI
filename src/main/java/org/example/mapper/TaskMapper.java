package org.example.mapper;

import org.example.enums.TaskStatus;
import org.example.models.Task;

import java.util.UUID;

public class TaskMapper {

    public static Task toTaskFromDescription(String description) {
        String id = generateUniqueId();
        Long currentTimeMillis = System.currentTimeMillis();

        return new Task(id, description, TaskStatus.TODO, currentTimeMillis, currentTimeMillis);
    }

    private static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
}
