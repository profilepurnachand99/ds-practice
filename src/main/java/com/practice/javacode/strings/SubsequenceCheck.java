package com.practice.javacode.strings;

public class SubsequenceCheck {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aebdc";

        boolean result = isSubsequence(s1, s2);
        System.out.println(s1 + " is subsequence of " + s2 + " ? " + result);
    }

    // Method to check if s1 is subsequence of s2
    public static boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++; // move in s1 if match
            }
            j++; // always move in s2
        }

        return i == s1.length(); // true if all chars of s1 matched
    }
}
