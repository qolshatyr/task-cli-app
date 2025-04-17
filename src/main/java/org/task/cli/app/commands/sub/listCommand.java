package org.task.cli.app.commands.sub;

import org.task.cli.app.commands.sub.list_sub_command.listDoneCommand;
import org.task.cli.app.commands.sub.list_sub_command.listInProgressCommand;
import org.task.cli.app.commands.sub.list_sub_command.listToDoCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "list", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for listing all tasks.", header = "To list all tasks.",
        commandListHeading = "%nSubCommand for list are:%n",
        subcommands = {listDoneCommand.class, listToDoCommand.class, listInProgressCommand.class})
public class listCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Listing all tasks");
        return 0;
    }
}
