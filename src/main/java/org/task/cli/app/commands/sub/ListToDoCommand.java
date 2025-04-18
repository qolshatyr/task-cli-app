package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.TaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "todo", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for all tasks with status ToDo.", header = "To list tasks that ToDo.",
        optionListHeading = "%nOptions are:%n")
public class ListToDoCommand implements Callable<Integer> {
    @CommandLine.ParentCommand
    private TaskCliCommand parent;

    @Override
    public Integer call() throws Exception {
        String text = parent.getTaskService().listTasks("ToDo");
        System.out.println(text);

        return 0;
    }
}
