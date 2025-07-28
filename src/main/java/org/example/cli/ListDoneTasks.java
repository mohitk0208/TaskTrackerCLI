package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.enums.TaskStatus;
import org.example.models.Task;
import picocli.CommandLine;

import java.util.List;

@CommandLine.Command(
        name = "done",
        description = "List all done tasks"
)
public class ListDoneTasks implements Runnable {
    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @Override
    public void run() {
        System.out.println("Listing all done tasks:");
        if (parent.taskService.getTasksByStatus(TaskStatus.DONE).isEmpty()) {
            System.out.println("No done tasks found.");
        } else {
            List<Task> tasks = parent.taskService.getTasksByStatus(TaskStatus.DONE);
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
