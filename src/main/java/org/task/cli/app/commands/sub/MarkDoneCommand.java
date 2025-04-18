package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "mark-done", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for marking tasks that done.", header = "To mark status done some task.",
        optionListHeading = "%nOptions are:%n")
public class MarkDoneCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @CommandLine.Parameters(index = "0", description = "id")
    private int id;

    @Override
    public Integer call() throws Exception {
        String state = "Done";
        parent.getTaskService().markEdit(id, state);

        return 0;
    }
}
