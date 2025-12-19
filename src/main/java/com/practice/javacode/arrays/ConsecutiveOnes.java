package com.practice.javacode.arrays;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1};

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // reset when 0 encountered
            }
        }

        System.out.println("Maximum consecutive ones: " + maxCount);
    }
}

