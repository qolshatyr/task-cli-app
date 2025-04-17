package org.task.cli.app.commands.sub.list_sub_command;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "todo", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for adding new tasks.", header = "Add SubCommand",
        optionListHeading = "%nOptions are:%n")
public class listToDoCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
