package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "in-progress", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for all tasks with status in-progress.", header = "To list task that in-progress.",
        optionListHeading = "%nOptions are:%n")
public class ListInProgressCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @Override
    public Integer call() throws Exception {
        String text = parent.getTaskService().listTasks("In-Progress");
        System.out.println(text);

        return 0;
    }
}
