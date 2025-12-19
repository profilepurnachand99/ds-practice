package com.practice.javacode.strings;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostCommonChar {
    public static void main(String[] args) {
        String input = "successes";

        // Count frequency of each character
        Map<Character, Long> freqMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        // Find the character with max frequency
        Map.Entry<Character, Long> mostCommon = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        System.out.println("Input: " + input);
        System.out.println("Frequency map: " + freqMap);
        if (mostCommon != null) {
            System.out.println("Most common repeating character: "
                    + mostCommon.getKey() + " -> " + mostCommon.getValue());
        }
    }
}

