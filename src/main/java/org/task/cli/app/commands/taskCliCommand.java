package org.task.cli.app.commands;

import org.task.cli.app.commands.sub.addTaskCliCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;


@CommandLine.Command(name = "task-cli", version = "1.0.0", mixinStandardHelpOptions = true,
        requiredOptionMarker = '*', description = "This is a CLI App for managing your tasks.", header = "Task CLI",
        optionListHeading = "%nOptions are:%n", footerHeading = "%nCopyright.", footer = "%nDeveloped by Zhamash Asylzhan.",
        commandListHeading = "%nCommads are:%n",
        subcommands = {
            addTaskCliCommand.class
})
public class taskCliCommand implements Callable<Integer> {
    final Integer SUCCESS = 0;
    final Integer FAILURE = 1;

    public static void main(String[] args) {
        int exitStatus = new CommandLine(new taskCliCommand()).execute("--help");
        System.exit(exitStatus);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("[task-cli] Task CLI");
        return SUCCESS;
    }
}
