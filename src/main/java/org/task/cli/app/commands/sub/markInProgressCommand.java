package org.task.cli.app.commands.sub;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "mark-in-progress", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for marking tasks that in-progress.", header = "To mark status in-progress some task.",
        optionListHeading = "%nOptions are:%n")
public class markInProgressCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
