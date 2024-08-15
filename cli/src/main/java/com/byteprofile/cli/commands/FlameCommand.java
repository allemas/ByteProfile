package com.byteprofile.cli.commands;

import com.byteprofile.agent.Premain;
import com.sun.tools.attach.VirtualMachine;
import picocli.CommandLine;

import java.io.File;

@CommandLine.Command(
        name = "flamegraph",
        description = "Generates a Flamegraph (default: jdk.ExecutionSample)",
        mixinStandardHelpOptions = true)
public class FlameCommand implements Runnable {

    @CommandLine.Option(
            names = {"-p", "--pid"},
            description = "PID Java Application")
    String agentPid = null;


    @Override
    public void run() {
        System.out.println("Hello world Flame cmd!" + agentPid);

        File agentFile = null;
        try {
            agentFile = new File(Premain.class.getProtectionDomain().getCodeSource().getLocation()
                    .toURI());

            VirtualMachine vm = VirtualMachine.attach(agentPid);
            vm.loadAgent(agentFile.getPath(), "");
            System.out.println("Agent has been injected in running JVM running with process id " + agentPid);
            vm.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
