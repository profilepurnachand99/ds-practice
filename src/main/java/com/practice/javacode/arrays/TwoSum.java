package com.practice.javacode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    //Check all pairs — O(n²) time, O(1) space.
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // not found
    }


    //Store complements in a map — O(n) time, O(n) space.
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // not found
    }

    //Sort array, then move pointers inward — O(n log n) time, O(1) space.
    //Loses original indices unless you store them separately.
    public static boolean twoSumTwoPointers(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }

    //Concise but less efficient for large arrays.
    //O(n²) time, O(1) space.
    public static boolean twoSumStreams(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .anyMatch(i -> IntStream.range(i + 1, nums.length)
                        .anyMatch(j -> nums[i] + nums[j] == target));
    }

}
