package com.practice.javacode.sort;

import java.util.*;

public class BucketSort {

    static void bucketSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        // 1. Number of buckets = sqrt(n)
        int bucketCount = (int) Math.ceil(Math.sqrt(n));

        // 2. Find max value (needed for bucket index formula)
        int max = arr[0];
        for (int v : arr) {
            if (v > max) max = v;
        }

        // 3. Create buckets
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 4. Distribute elements using your formula:
        //    index = ceil( value * bucketCount / maxValue )
        for (int value : arr) {
            int index = (int) Math.ceil((double) value * bucketCount / max);

            // index may become equal to bucketCount → fix it
            if (index == bucketCount) index--;

            buckets.get(index).add(value);
        }

        // 5. Sort each bucket
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 6. Merge buckets back into array
        int idx = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[idx++] = value;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {42, 32, 23, 52, 25, 47, 51};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        bucketSort(arr);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}

