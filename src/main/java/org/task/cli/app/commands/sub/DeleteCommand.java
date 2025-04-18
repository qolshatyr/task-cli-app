package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "delete", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for deleting tasks.", header = "To delete task.")
public class DeleteCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @CommandLine.Parameters(index = "0", description = "id")
    private int id;

    @Override
    public Integer call() throws Exception {
        parent.getTaskService().delete(id);

        return 0;
    }
}
