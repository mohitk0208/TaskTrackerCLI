package org.example.cli;

import org.example.TaskTrackerCLI;
import picocli.CommandLine;

@CommandLine.Command(
        name = "delete",
        description = "Delete a task by its id."
)
public class DeleteTask implements Runnable{

    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @CommandLine.Parameters(index = "0", description = "The id of the task to delete.")
    private String taskId;

    @Override
    public void run() {
        parent.taskService.deleteTask(taskId);

        System.out.println("Task with id " + taskId + " has been deleted.");
    }
}
