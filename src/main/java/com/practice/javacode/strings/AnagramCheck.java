package com.practice.javacode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramCheck {

    /*
     * For general strings, use the HashMap approach.
     * For lowercase-only strings, use the array approach (fastest).
     * For quick readability, use the sorting approach.
     */
    //Sort both strings and compare — O(n log n) time, O(1) extra space.
    public static boolean isAnagram_Sorting(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    //Count character frequencies and compare — O(n) time, O(n) space.
    public static boolean isAnagram_Map(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) == 0) freq.remove(c);
        }
        return freq.isEmpty();
    }

    //If only lowercase English letters are allowed, use an int[26] array — O(n) time, O(1) space.
    public static boolean isAnagram_Array(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int val : count) {
            if (val != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram_Streams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return s1.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(s2.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }


}
