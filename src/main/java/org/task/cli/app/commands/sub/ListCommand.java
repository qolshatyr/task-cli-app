package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "list", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for listing all tasks.", header = "To list all tasks.",
        commandListHeading = "%nSubCommand for list are:%n")
public class ListCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @Override
    public Integer call() throws Exception {
        String text = parent.getTaskService().listTasks("all");
        System.out.println(text);

        return 0;
    }
}
