package com.practice.javacode.recursion;

public class Factorial {

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " = " + factorialRecursive(num));
    }

    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1; // base case
        }
        return n * factorialRecursive(n - 1); // recursive call
    }

    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}

