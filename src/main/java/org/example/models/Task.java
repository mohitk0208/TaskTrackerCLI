package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.TaskStatus;

@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Getter
    private String id;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private TaskStatus status;
    @Getter
    @Setter
    private Long updatedAt;
    @Getter
    private Long createdAt;

    @Override
    public String toString() {
        return String.format("id: %s, description: %s, status: %s, createdAt: %d, updatedAt: %d",
                id, description, status, createdAt, updatedAt);
    }
}