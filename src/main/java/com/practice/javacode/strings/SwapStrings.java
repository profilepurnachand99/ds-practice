package com.practice.javacode.strings;

public class SwapStrings {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "pqrs";
        // Swapping without using a third variable

        str1 = str1 + str2;
        // Concatenate str1 and str2 and store in str1

        str2 = str1.substring(0, str1.length() - str2.length());
        // Extract the initial part (original str1) from the concatenated string

        str1 = str1.substring(str2.length());
        // Extract the remaining part (original str2) from the concatenated string

        System.out.println("After swapping: str1 = " + str1 + ", str2 = " + str2);
    }
}
