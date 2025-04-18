package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "mark-in-progress", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for marking tasks that in-progress.", header = "To mark status in-progress some task.",
        optionListHeading = "%nOptions are:%n")
public class MarkInProgressCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @CommandLine.Parameters(index = "0", description = "id")
    private int id;

    @Override
    public Integer call() throws Exception {
        String state = "In-Progress";
        parent.getTaskService().markEdit(id, state);

        return 0;
    }
}
