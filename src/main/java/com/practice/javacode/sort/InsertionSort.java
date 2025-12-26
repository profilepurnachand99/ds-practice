package com.practice.javacode.sort;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at the correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}

