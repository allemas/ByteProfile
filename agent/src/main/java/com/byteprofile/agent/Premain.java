package com.byteprofile.agent;


import com.byteprofile.core.StackTraceProfiler;
import jdk.jfr.consumer.RecordedClass;
import jdk.jfr.consumer.RecordingStream;

import java.lang.instrument.Instrumentation;

public class Premain {

    private static Instrumentation instrumentation;

    /**
     * JVM hook to dynamically load javaagent at runtime.
     * <p>
     * The agent class may have an agentmain method for use when the agent is
     * started after VM startup.
     *
     * @param args
     * @param inst
     * @throws Exception
     */
    public static void agentmain(String args, Instrumentation inst) {
        StackTraceProfiler profiler = new StackTraceProfiler();
        profiler.run();


        // exp
        var rs = new RecordingStream();
        rs.enable("jdk.JavaMonitorWait");
        rs.enable("jdk.JVMInformation");
        rs.enable("jdk.CPUInformation");

        rs.onEvent("jdk.CPUInformation", event -> {
            System.out.println("BOOOOOL ------>   " + event.getDuration());
        });

        rs.startAsync();

    }


}
//https://github.com/parttimenerd/tiny-profiler/tree/main