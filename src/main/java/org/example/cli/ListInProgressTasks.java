package org.example.cli;

import org.example.enums.TaskStatus;
import picocli.CommandLine;

@CommandLine.Command(
        name = "in-progress",
        description = "List all in-progress tasks"
)
public class ListInProgressTasks implements Runnable{

    @CommandLine.ParentCommand
    private ListTasks parent;

    @Override
    public void run() {
        System.out.println("Listing all in-progress tasks:");
        if (parent.parent.taskService.getTasksByStatus(TaskStatus.IN_PROGRESS).isEmpty()) {
            System.out.println("No in-progress tasks found.");
        } else {
            parent.parent.taskService.getTasksByStatus(TaskStatus.IN_PROGRESS)
                    .forEach(System.out::println);
        }
    }
}
