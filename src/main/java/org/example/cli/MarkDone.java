package org.example.cli;

import org.example.TaskTrackerCLI;
import org.example.enums.TaskStatus;
import picocli.CommandLine;

@CommandLine.Command(
        name = "mark-done",
        description = "Mark a task as done"
)
public class MarkDone implements Runnable {

    @CommandLine.ParentCommand
    private TaskTrackerCLI parent;

    @CommandLine.Parameters(index = "0", description = "The ID of the task to mark done.")
    private String id;

    @Override
    public void run() {
        parent.taskService.updateTaskStatus(id, TaskStatus.DONE);
    }
}
