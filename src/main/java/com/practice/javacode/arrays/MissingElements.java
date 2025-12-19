package com.practice.javacode.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingElements {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1, 3, 2}; // supposed to be 1..6, but duplicates exist

        int n = 6; // expected range is 1..n

        // Put all elements into a Set to remove duplicates
        Set<Integer> unique = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        // Find missing elements by checking which numbers 1..n are not in the set
        List<Integer> missing = IntStream.rangeClosed(1, n)
                .filter(i -> !unique.contains(i))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Unique elements: " + unique);
        System.out.println("Missing elements: " + missing);
    }
}
