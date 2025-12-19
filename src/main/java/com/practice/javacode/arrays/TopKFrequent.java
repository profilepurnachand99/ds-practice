package com.practice.javacode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2)); // [1,2]
    }

    //HashMap + Heap	O(n log k)	O(n)
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        heap.addAll(freq.entrySet());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll().getKey());
        }
        return result;
    }

    //HashMap + Bucket	O(n)	O(n)
    public static List<Integer> topKFrequent_BucketSort(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // bucket where index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        return result.subList(0, k);
    }

    //Streams	O(n log n)	O(n)
    public static List<Integer> topKFrequent_Streams(int[] nums, int k) {
        Map<Integer, Long> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        return freq.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

