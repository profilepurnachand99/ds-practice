package com.practice.javacode.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicatesStreams {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "apple", "orange", "banana", "apple"};

        // Count occurrences using groupingBy
        Map<String, Long> countMap = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Counts (unsorted): " + countMap);

        // Sort by key (alphabetical)
        System.out.println("\nSorted by key:");
        countMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        // Sort by value (frequency descending)
        System.out.println("\nSorted by frequency (descending):");
        countMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}

