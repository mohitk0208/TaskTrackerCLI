package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.TaskStatus;

@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Getter private String id;
    @Getter @Setter private String description;
    @Getter @Setter private TaskStatus status;
    @Getter @Setter private Long updatedAt;
    @Getter private Long createdAt;
}