package org.task.cli.app.commands.sub;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "add", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for adding new tasks.", header = "Add SubCommand",
        optionListHeading = "%nOptions are:%n")
public class addCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("[task-cli] Adding task");
        return 0;
    }
}
