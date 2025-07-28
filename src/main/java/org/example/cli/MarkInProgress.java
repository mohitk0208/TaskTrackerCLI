package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.enums.TaskStatus;
import picocli.CommandLine;

@CommandLine.Command(
        name = "mark-in-progress",
        description = "Mark the task as in-progress"
)
public class MarkInProgress implements Runnable {
    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @CommandLine.Parameters(index = "0", description = "The ID of the task to mark in-progress")
    private String id;

    @Override
    public void run() {
        parent.taskService.updateTaskStatus(id, TaskStatus.IN_PROGRESS);
    }
}
