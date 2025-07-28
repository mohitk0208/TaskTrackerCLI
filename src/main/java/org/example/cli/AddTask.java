package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.models.Task;
import picocli.CommandLine;

@CommandLine.Command(
        name = "add",
        mixinStandardHelpOptions = true,
        description = "Add a new task to the task tracker."
)
public class AddTask implements Runnable {

    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;


    @CommandLine.Parameters(index = "0", description = "The description of the task to be added.")
    private String description;

    public AddTask() {
    }

    @Override
    public void run() {
        Task newTask = parent.taskService.createTask(description);

        System.out.printf("Successfully added task:(%s)%n", newTask.toString());
    }
}
