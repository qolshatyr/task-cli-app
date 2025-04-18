package org.task.cli.app.commands.sub;
import org.task.cli.app.commands.TaskCliCommand;
import org.task.cli.app.model.Task;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "add", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for adding new tasks.", header = "To add new task.")
public class AddCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @CommandLine.Parameters(index = "0", description = "description of task")
    private String description;

    @Override
    public Integer call() throws Exception {
        Task task = new Task();
        task.setDescription(description);

        parent.getTaskService().save(task);

        System.out.println("[INFO] Added new task: " + description);
        return 0;
    }
}
