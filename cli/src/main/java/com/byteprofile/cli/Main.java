package com.byteprofile.cli;

import com.byteprofile.cli.commands.FlameCommand;
import picocli.CommandLine;

@CommandLine.Command(
        name = "",
        subcommands = {
                FlameCommand.class,
        },
        mixinStandardHelpOptions = true,
        description = "Generates a flamegraph according to the selected event-type",
        version = "0.0.0"
)
public class Main {

    public static void main(String[] args) {
        int code = new CommandLine(new Main()).execute(args);
        System.exit(code);
    }
}