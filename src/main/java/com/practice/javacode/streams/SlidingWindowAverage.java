package com.practice.javacode.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlidingWindowAverage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 8, 15, 16, 23, 42);
        int windowSize = 3;

        // Compute sliding window averages
        List<Double> averages = IntStream.range(0, numbers.size() - windowSize + 1)
                .mapToObj(i -> numbers.subList(i, i + windowSize)) // each window
                .map(window -> window.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)) // average of window
                .collect(Collectors.toList());

        // Print results
        System.out.println("Sliding window averages: " + averages);
    }
}
