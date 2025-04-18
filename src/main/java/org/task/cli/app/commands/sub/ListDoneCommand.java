package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "done", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for all tasks with status done.", header = " To list tasks that done.",
        optionListHeading = "%nOptions are:%n")
public class ListDoneCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @Override
    public Integer call() throws Exception {
        String text = parent.getTaskService().listTasks("Done");
        System.out.println(text);

        return 0;
    }
}
