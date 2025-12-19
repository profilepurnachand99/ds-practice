package com.practice.javacode.arrays.duplicates;

import java.util.*;

public class ArrayDuplicates {
    /*
     * If you’re writing production code, use the HashSet approach for clarity and speed.
     * If you need minimal memory usage, use the sorting approach.
     * If you want duplicate counts, use the Map approach.
     * */
    public static void main(String[] args) {
    }

    public static boolean hasDuplicates_NestedLoops(int[] arr) {
        //O(n²) time, O(1) space
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicates_Sorting(int[] arr) {
        //O(n log n) time, O(1) extra space
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicates_HashSet(int[] arr) {
        //O(n) time, O(n) space
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.add(num)) { // add() returns false if element already exists
                return true;
            }
        }
        return false;
    }

    public static boolean hasDuplicates_Streams(int[] arr) {
        //O(n) time, O(n) space
        return Arrays.stream(arr).distinct().count() < arr.length;
    }

    public static boolean hasDuplicates_Map(int[] arr) {
        //O(n) time, O(n) space
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > 1) {
                return true;
            }
        }
        return false;
    }

}
