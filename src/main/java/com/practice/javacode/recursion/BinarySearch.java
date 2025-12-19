package com.practice.javacode.recursion;

public class BinarySearch {

    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // not found
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // found
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, left, mid - 1); // search left half
        } else {
            return binarySearchRecursive(arr, target, mid + 1, right); // search right half
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        int result = binarySearchRecursive(arr, target, 0, arr.length - 1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
