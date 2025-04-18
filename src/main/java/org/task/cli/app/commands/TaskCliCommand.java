package org.task.cli.app.commands;

import org.task.cli.app.commands.sub.*;
import org.task.cli.app.service.TaskService;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "task-cli", version = "1.0.0", mixinStandardHelpOptions = true,
        requiredOptionMarker = '*', description = "This is a CLI App for managing your tasks.", header = "Task CLI",
        optionListHeading = "%nOptions are:%n", footerHeading = "%nCopyright.", footer = "%nDeveloped by Zhamash Asylzhan.",
        commandListHeading = "%nCommands are:%n",
        subcommands = {
            AddCommand.class, DeleteCommand.class, UpdateCommand.class, MarkInProgressCommand.class,
                MarkDoneCommand.class, ListCommand.class, ListDoneCommand.class, ListToDoCommand.class,
                ListInProgressCommand.class})
public class TaskCliCommand implements Callable<Integer> {
    private final TaskService taskService = new TaskService();
    final Integer SUCCESS = 0;

    public TaskService getTaskService() {
        return taskService;
    }

    public static void main(String[] args) {
        int exitStatus = new CommandLine(new TaskCliCommand()).execute(args);
        System.exit(exitStatus);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[task-cli] Task CLI");
        return SUCCESS;
    }
}
