package com.byteprofile.core;

import java.io.IOException;
import java.util.Arrays;

public class StackTraceProfiler implements Runnable {
    Store store = new Store();


    /**
     * @Todo add better sleep time management
     * extract data to Store and not print it to stdout
     */
    @Override
    public void run() {
        while (true) {
            Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> {
                store.addSample(stackTraceElements);
                /**
                 System.out.println("=====" + thread.getName() + "==");
                 Arrays.stream(stackTraceElements).forEach(stackTraceElement ->
                 {
                 System.out.println(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                 });
                 **/
            });

            try {
                Thread.sleep(2000);
                store.methodSampleCount.forEach((name, count) -> {
                    System.out.println(String.format("%s : %d", name, count));
                });

                try {
                    store.createFlameGraphFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } catch (InterruptedException e) {
                break;
            }
        }
    }

}
