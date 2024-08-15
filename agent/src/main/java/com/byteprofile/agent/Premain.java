package com.byteprofile.agent;


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
        System.out.println("Agentmain");
    }


}
//https://github.com/parttimenerd/tiny-profiler/tree/main