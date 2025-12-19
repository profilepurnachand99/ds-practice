package com.practice.javacode.strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BigramFrequency {
    public static void main(String[] args) {
        String text = "Java streams are powerful and Java streams are flexible";
        // Split text into words
        List<String> words = Arrays.asList(text.split("\\s+"));
        // Generate bigrams
        List<String> bigrams = IntStream.range(0, words.size() - 1)
                .mapToObj(i -> words.get(i) + " " + words.get(i + 1))
                .collect(Collectors.toList());
        // Count frequency of each bigram
        Map<String, Long> bigramFrequency = bigrams.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Print results
        bigramFrequency.forEach((bigram, freq) ->
                System.out.println(bigram + " -> " + freq));
    }
}

