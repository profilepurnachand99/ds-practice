package com.practice.javacode.linkedlists;

/**
 * NeetCode Problem 2 (Linked List): Merge Two Sorted Lists
 *
 * Problem Description:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Examples:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * - The number of nodes in both lists is in the range [0, 50].
 * - -100 <= Node.val <= 100
 * - Both list1 and list2 are sorted in non-decreasing order.
 *
 * Approach:
 * We can solve this problem using both iterative and recursive approaches:
 *
 * Iterative Approach:
 * 1. Create a dummy node to serve as the head of the merged list
 * 2. Use a tail pointer to keep track of the last node in the merged list
 * 3. Compare the values of the current nodes in both lists:
 *    - Add the smaller one to the merged list
 *    - Move the pointer of that list forward
 * 4. If one list is exhausted, append the remaining nodes of the other list
 * 5. Return the next of the dummy node (the actual head of the merged list)
 *
 * Recursive Approach:
 * 1. Base cases:
 *    - If list1 is null, return list2
 *    - If list2 is null, return list1
 * 2. Compare the values of the current nodes in both lists:
 *    - If list1.val <= list2.val, set list1.next to the result of merging list1.next and list2, and return list1
 *    - Otherwise, set list2.next to the result of merging list1 and list2.next, and return list2
 *
 * Time Complexity: O(n + m) where n and m are the lengths of the two lists
 * Space Complexity: O(1) for the iterative approach, O(n + m) for the recursive approach due to the call stack
 */
public class LLMergeSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to serve as the head of the merged list
        ListNode dummy = new ListNode(0);
        // Use a tail pointer to keep track of the last node in the merged list
        ListNode tail = dummy;

        // Iterate while both lists have nodes
        while (l1 != null && l2 != null) {
            // Compare the values of the both lists
            if (l1.val <= l2.val) {
                // Add the smaller node (from list1) to the merged list
                tail.next = l1;
                // Move the pointer of list1 forward
                l1 = l1.next;
            } else {
                // Add the smaller node (from list2) to the merged list
                tail.next = l2;
                // Move the pointer of list2 forward
                l2 = l2.next;
            }
            // Move the tail pointer forward
            tail = tail.next;
        }

        // Attach the remaining part (only one of these will run)
        // If one list is exhausted, append the remaining nodes of the other list to merged list
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        // Return the next of the dummy node (the actual head of the merged list)
        return dummy.next;
    }

    // Compare the values of the current nodes
    public ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Compare the values of the current nodes
        if (l1.val <= l2.val) {
            // If list1.val is smaller, set list1.next to the result of merging list1.next and list2
            l1.next = mergeTwoListsRec(l1.next, l2);
            return l1;
        } else {
            // If list2.val is smaller, set list2.next to the result of merging list1 and list2.next
            l2.next = mergeTwoListsRec(l1, l2.next);
            return l2;
        }
    }

    /**
     * Main method to demonstrate the solution with example inputs.
     */
    public static void main(String[] args) {
        LLMergeSortedLists solution = new LLMergeSortedLists();

        // Example 1: [1,2,4], [1,3,4] -> [1,1,2,3,4,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        ListNode merged1 = solution.mergeTwoLists(list1, list2);
        System.out.println("Merged List (Iterative): " + merged1);

        // Example 2: [], [] -> []
        ListNode list3 = null;
        ListNode list4 = null;
        System.out.println("\nList 3: " + list3);
        System.out.println("List 4: " + list4);
        ListNode merged2 = solution.mergeTwoListsRec(list3, list4);
        System.out.println("Merged List (Recursive): " + merged2);

        // Example 3: [], [0] -> [0]
        ListNode list5 = null;
        ListNode list6 = new ListNode(0);
        System.out.println("\nList 5: " + list5);
        System.out.println("List 6: " + list6);
        ListNode merged3 = solution.mergeTwoLists(list5, list6);
        System.out.println("Merged List (Iterative): " + merged3);

        // Let's trace through the execution of Example 1 using the iterative approach:
        // list1 = 1 -> 2 -> 4
        // list2 = 1 -> 3 -> 4

        // Initialize dummy = -1, tail = dummy

        // Iteration 1:
        // Compare list1.val = 1 and list2.val = 1
        // Since 1 <= 1, add list1 to the merged list: tail.next = list1
        // Move list1 forward: list1 = 2 -> 4
        // Move tail forward: tail = 1
        // Current merged list: -1 -> 1

        // Iteration 2:
        // Compare list1.val = 2 and list2.val = 1
        // Since 1 < 2, add list2 to the merged list: tail.next = list2
        // Move list2 forward: list2 = 3 -> 4
        // Move tail forward: tail = 1
        // Current merged list: -1 -> 1 -> 1

        // Iteration 3:
        // Compare list1.val = 2 and list2.val = 3
        // Since 2 < 3, add list1 to the merged list: tail.next = list1
        // Move list1 forward: list1 = 4
        // Move tail forward: tail = 2
        // Current merged list: -1 -> 1 -> 1 -> 2

        // Iteration 4:
        // Compare list1.val = 4 and list2.val = 3
        // Since 3 < 4, add list2 to the merged list: tail.next = list2
        // Move list2 forward: list2 = 4
        // Move tail forward: tail = 3
        // Current merged list: -1 -> 1 -> 1 -> 2 -> 3

        // Iteration 5:
        // Compare list1.val = 4 and list2.val = 4
        // Since 4 <= 4, add list1 to the merged list: tail.next = list1
        // Move list1 forward: list1 = null
        // Move tail forward: tail = 4
        // Current merged list: -1 -> 1 -> 1 -> 2 -> 3 -> 4

        // list1 is now null, so we append the remaining nodes of list2: tail.next = list2
        // Final merged list: -1 -> 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Return dummy.next = 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
