package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.enums.TaskStatus;
import org.example.models.Task;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(
        name = "todo",
        description = "List all todo tasks"
)
public class ListTodoTasks implements Runnable {
    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @Override
    public void run() {
        System.out.println("Listing all todo tasks:");
        if (parent.taskService.getTasksByStatus(TaskStatus.TODO).isEmpty()) {
            System.out.println("No todo tasks found.");
        } else {
            List<Task> tasks = parent.taskService.getTasksByStatus(TaskStatus.TODO);
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
