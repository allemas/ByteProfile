package com.byteprofile.cli.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "flamegraph",
        description = "Generates a Flamegraph (default: jdk.ExecutionSample)",
        mixinStandardHelpOptions = true)
public class FlameCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello world Flame cmd!");

    }
}
