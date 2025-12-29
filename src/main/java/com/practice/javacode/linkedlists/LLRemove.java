package com.practice.javacode.linkedlists;

public class LLRemove {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;  // skip the node
            } else {
                curr = curr.next;            // move forward
            }
        }

        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = head, nxt = null;

        while (curr != null) {
            nxt = curr.next;
            if (curr.val == val) {
                prev.next = nxt;
            } else {
                prev = curr;
            }
            curr = nxt;
        }

        return dummy.next;
    }

    public ListNode removeElementsRec(ListNode head, int val) {
        if (head == null) return null;

        head.next = removeElementsRec(head.next, val);

        return head.val == val ? head.next : head;
    }


    public ListNode removeElements_Without_Dummy(ListNode head, int val) {
        // 1. Remove matching nodes at the head
        while (head != null && head.val == val) {
            head = head.next;
        }

        // If list becomes empty
        if (head == null) return null;

        // 2. Now remove matching nodes after the head
        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;   // skip the node
            } else {
                prev = curr;             // move prev forward
            }
            curr = curr.next;            // always move curr forward
        }

        return head;
    }

}
