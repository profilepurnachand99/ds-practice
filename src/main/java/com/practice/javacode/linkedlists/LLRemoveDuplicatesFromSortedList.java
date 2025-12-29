package com.practice.javacode.linkedlists;

public class LLRemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;   // skip duplicate
            } else {
                curr = curr.next;             // move forward
            }
        }

        return head;
    }

}
