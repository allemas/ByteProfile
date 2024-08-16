package com.byteprofile.core;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Store bootstrap, here we will store all StacktraceElement, count them and create data struct for flamegraph generation
 */
public class Store {

    public Store() {
    }

    private final Map<String, Long> methodOnTopSampleCount = new HashMap<>();
    private final Map<String, Long> methodSampleCount = new HashMap<>();

    private long totalSampleCount = 0;


    public void addSample(StackTraceElement[] stackTraceElements) {
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement.getClassName());
        }

    }

}
