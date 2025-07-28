package org.example.cli;

import org.example.TaskTrackerCLI;
import picocli.CommandLine;

@CommandLine.Command(
        name = "update",
        description = "Update a task"
)
public class UpdateTask implements Runnable {

    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @CommandLine.Parameters(index = "0", description = "The ID of the task to update")
    private String taskId;

    @CommandLine.Parameters(index = "1", description = "The new description of the task")
    private String newDescription;

    @Override
    public void run() {
        System.out.println("Updating task with ID: " + taskId);

        parent.taskService.updateTaskDescription(taskId, newDescription);
        System.out.println("Task updated successfully.");
    }
}
