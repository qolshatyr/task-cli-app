package org.task.cli.app.commands.sub;

import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "delete", mixinStandardHelpOptions = true, requiredOptionMarker = '*',
        description = "This is a subcommand for deleting tasks.", header = "To delete task.")
public class deleteCommand implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("[task-cli] Deleting task.");
        return 0;
    }
}
