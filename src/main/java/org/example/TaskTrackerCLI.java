package org.example;

import org.example.cli.*;
import org.example.respository.JsonTaskRepository;
import org.example.respository.TaskRepository;
import org.example.service.TaskService;
import org.example.service.TaskServiceImpl;
import picocli.CommandLine;

@CommandLine.Command(
        name = "task",
        mixinStandardHelpOptions = true,
        description = "A CLI application to manage tasks.",
        subcommands = {AddTask.class, UpdateTask.class, ListTasks.class, MarkDone.class, MarkInProgress.class, DeleteTask.class}
)
public class TaskTrackerCLI implements Runnable {
    public TaskService taskService;

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new TaskTrackerCLI());

        int exitCode = cmd.execute(args);

        System.exit(exitCode);
    }

    public TaskTrackerCLI() {
        TaskRepository taskRepository = new JsonTaskRepository("data/tasks.json");
        this.taskService = new TaskServiceImpl(taskRepository);
    }

    @Override
    public void run() {
        System.out.println("Specify a command: add, list, update, delete");
    }
}
