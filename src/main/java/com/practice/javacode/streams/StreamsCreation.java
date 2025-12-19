package com.practice.javacode.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsCreation {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        stream1.forEach(System.out::println);

        Stream<Integer> stream = Stream.iterate(1, n -> n + 1);
        stream.limit(5).forEach(System.out::println); // prints 1 to 5

        Stream<Double> stream2 = Stream.generate(Math::random);
        stream2.limit(3).forEach(System.out::println); // prints 3 random numbers

        int[] arr = {1, 0, 1, 0, 1, 1};
        int sum = Arrays.stream(arr).sum();
        System.out.println("sum: " + sum);
    }
}
