package com.practice.javacode.linkedlists;

public class CircularSinglyLinkedList {
    private Node tail; // tail.next is the head

    public CircularSinglyLinkedList() {
        tail = null;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtHead(5);
        list.printList(); // 5 -> 10 -> 20 -> 30 -> (back to head)
        list.deleteValue(20);
        list.printList(); // 5 -> 10 -> 30 -> (back to head)
    }

    // Insert at beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);

        if (tail == null) { // empty list
            tail = newNode;
            tail.next = tail;
            return;
        }

        newNode.next = tail.next; // new node points to head
        tail.next = newNode;      // tail points to new head
    }

    // Print list
    public void printList() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = tail.next; // head
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next);

        System.out.println("(back to head)");
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
            return;
        }

        newNode.next = tail.next; // new node points to head
        tail.next = newNode;      // old tail points to new node
        tail = newNode;           // new node becomes tail
    }

    // Delete a value
    public void deleteValue(int value) {
        if (tail == null) return; // empty list

        Node current = tail.next; // start at head
        Node prev = tail;

        do {
            if (current.data == value) {
                // If only one node
                if (current == tail && current == tail.next) {
                    tail = null;
                }
                // If deleting tail
                else if (current == tail) {
                    prev.next = current.next;
                    tail = prev;
                }
                // Normal delete
                else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
    }

}

