package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.models.Task;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(
        name = "list",
        description = "List all tasks",
        subcommands = {ListTodoTasks.class, ListDoneTasks.class, ListInProgressTasks.class}
)
public class ListTasks implements Runnable {

    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @Override
    public void run() {
        System.out.println("Listing all tasks:");
        if (parent.taskService.getAllTasks().isEmpty()) {
            System.out.println("No tasks found.");
        }

        List<Task> tasks = parent.taskService.getAllTasks();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
