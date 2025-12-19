package com.practice.javacode.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String input = "swiss";

        Character result = input.chars() // IntStream of chars
                .mapToObj(c -> (char) c) // convert to Character
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new, // preserve insertion order
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1) // only non‑repeating
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println("First non‑repeating character: " + result);
    }
}

