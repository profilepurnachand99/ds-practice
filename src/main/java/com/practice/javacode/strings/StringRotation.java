package com.practice.javacode.strings;

public class StringRotation {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";

        boolean result = isRotation(s1, s2);

        System.out.println(s2 + " is rotation of " + s1 + " ? " + result);
    }

    public static boolean isRotation(String s1, String s2) {
        // Lengths must match
        if (s1.length() != s2.length()) {
            return false;
        }
        // Check if s2 is a substring of s1+s1
        return (s1 + s1).contains(s2);
    }
}

