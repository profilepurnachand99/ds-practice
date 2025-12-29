package com.practice.javacode.linkedlists;

public class LLReverse {

    ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next; // store next
            curr.next = prev; // reverse pointer
            prev = curr;      // move prev forward
            curr = next;      // move curr forward
        }

        return prev; // new head
    }

    /*
       1 → 2 → 3 → null
       Call-1: head 1, reverse(2)
       Call-2: head 2, reverse(3)
       Call-3: head 3, head.next is null base condition return 3. 3 is the new head of reversed list so far.
       1 → 2 → 3 → null --->  3 → null

       RETURNING TO CALL 2 (head = 2, newHead = 3)
       2 → 3 → null  --->  3 → 2 → null

       RETURNING TO CALL 1 (head = 1, newHead = 3)
       1 → 2 → null and the reversed tail is: 3 → 2 → null --->  3 → 2 → 1 → null
     */
    ListNode reverseRecursive(ListNode head) {
        // Base case: empty list or last node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseRecursive(head.next);

        head.next.next = head; // reverse the link
        head.next = null;      // break the old link

        return newHead;
    }
}