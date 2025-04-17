package org.task.cli.app.commands.sub;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "mark-done", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for marking tasks that done.", header = "To mark status done some task.",
        optionListHeading = "%nOptions are:%n")
public class markDoneCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
