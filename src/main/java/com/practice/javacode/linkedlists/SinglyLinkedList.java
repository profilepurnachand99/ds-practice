package com.practice.javacode.linkedlists;

public class SinglyLinkedList {
    private Node head;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtHead(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtPosition(15, 1);
        list.printList(); // 10 -> 15 -> 20 -> 30 -> null
        list.deleteValue(20);
        list.printList(); // 10 -> 15 -> 30 -> null
        System.out.println(list.search(30)); // true
        System.out.println(list.search(50)); // false
    }

    // Insert at beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at a given position (0-based index)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete first occurrence of a value
    public void deleteValue(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // Delete at position (0-based)
    public void deleteAtPosition(int position) {
        if (head == null) return;

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search for a value
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }

    // Print list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}