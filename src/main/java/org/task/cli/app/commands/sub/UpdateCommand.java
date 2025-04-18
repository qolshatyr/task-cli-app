package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import org.task.cli.app.service.TaskService;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "update", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for adding new tasks.", header = "To update some task.",
        optionListHeading = "%nOptions are:%n")
public class UpdateCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @CommandLine.Parameters(index = "0", description = "id")
    private int id;

    @CommandLine.Parameters(index = "1", description = "new description")
    private String description;

    @Override
    public Integer call() throws Exception {
        TaskService taskService = new TaskService();
        taskService.edit(id, description);

        return 0;
    }
}
