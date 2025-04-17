package org.task.cli.app.commands.sub;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "mark-todo", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for adding new tasks.", header = "To mark status ToDo some task.",
        optionListHeading = "%nOptions are:%n")
public class markToDoCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
