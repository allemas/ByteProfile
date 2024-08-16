package com.byteprofile.core;

import java.util.Arrays;

public class StackTraceProfiler implements Runnable {


    /**
     * @Todo add better sleep time management
     * extract data to Store and not print it to stdout
     */
    @Override
    public void run() {
        while (true) {
            Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> {
                System.out.println("=====" + thread.getName() + "==");
                Arrays.stream(stackTraceElements).forEach(stackTraceElement ->
                {
                    System.out.println(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                });
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
