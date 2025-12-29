package com.practice.javacode.linkedlists;

public class LLPalindrome {
    /*
     Original: 1 → 2 → 3 → 2 → 1
     Second half: 3 → 2 → 1
     Reversed:    1 → 2 → 3
    */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle using slow & fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow);

        // 3. Compare first half and reversed second half
        ListNode left = head;
        ListNode right = secondHalf;

        while (right != null) {   // only need to check second half
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Helper: reverse linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}
