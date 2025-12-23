package com.practice.javacode.linkedlists;

public class CircularDoublyLinkedList {
    private Node head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtHead(5);
        list.printForward(); // 5 <-> 10 <-> 20 <-> 30 <-> (back to head)
        list.printBackward(); // 30 <-> 20 <-> 10 <-> 5 <-> (back to tail)
        list.deleteValue(20);
        list.printForward(); // 5 <-> 10 <-> 30 <-> (back to head)
    }

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        if (head == null) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node tail = head.prev;

        newNode.next = head;
        newNode.prev = tail;

        tail.next = newNode;
        head.prev = newNode;
    }

    // Delete a value
    public void deleteValue(int value) {
        if (head == null) return;

        Node current = head;

        do {
            if (current.data == value) {

                // Only one node
                if (current.next == current) {
                    head = null;
                    return;
                }

                Node prevNode = current.prev;
                Node nextNode = current.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                // If deleting head, move head
                if (current == head) {
                    head = nextNode;
                }

                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Print forward
    public void printForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // Print backward
    public void printBackward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node tail = head.prev;
        Node temp = tail;

        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != tail);

        System.out.println("(back to tail)");
    }
}