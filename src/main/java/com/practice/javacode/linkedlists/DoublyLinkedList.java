package com.practice.javacode.linkedlists;

class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Insert at head
    public void insertAtHead(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        DoublyNode newNode = new DoublyNode(data);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at position (0-based)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            insertAtTail(data);
            return;
        }

        DoublyNode newNode = new DoublyNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete first occurrence of a value
    public void deleteValue(int value) {
        DoublyNode temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) return; // not found

        // If deleting head
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        // If deleting tail
        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        // Middle node
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Delete at position (0-based)
    public void deleteAtPosition(int position) {
        if (head == null) return;

        if (position == 0) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }

        DoublyNode temp = head;
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Print forward
    public void printForward() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Print backward
    public void printBackward() {
        DoublyNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtPosition(15, 1);
        list.printForward(); // 10 <-> 15 <-> 20 <-> 30 <-> null
        list.printBackward(); // 30 <-> 20 <-> 15 <-> 10 <-> null
        list.deleteValue(20);
        list.printForward(); // 10 <-> 15 <-> 30 <-> null
    }
}
