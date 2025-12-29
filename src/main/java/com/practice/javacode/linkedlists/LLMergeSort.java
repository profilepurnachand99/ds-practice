package com.practice.javacode.linkedlists;

public class LLMergeSort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. Split list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid;

        // 2. Sort each half
        left = sortList(left);
        right = sortList(right);

        // 3. Merge sorted halves
        return merge(left, right);
    }

    // Find middle using slow/fast pointers
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut the list into two halves
        prev.next = null;
        return slow;
    }

    // Merge two sorted lists (same as mergeTwoLists)
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

}
