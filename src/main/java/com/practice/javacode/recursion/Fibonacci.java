package com.practice.javacode.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci of " + n + " = " + fibonacci(n));
        //Fibonacci of 10 = 55
    }

    //Recursion	O(2^n)	O(n)	Simple, but very slow
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Iteration	O(n)	O(1)	Best for large n
    public static int fibonacciIterative(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    private static Map<Integer, Integer> memo = new HashMap<>();
    //Memoization	O(n)	O(n)	Fast, avoids recomputation
    public static int fibonacciDP(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int value = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, value);
        return value;
    }
}
