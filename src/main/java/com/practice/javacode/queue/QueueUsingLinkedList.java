package com.practice.javacode.queue;

public class QueueUsingLinkedList {
    private Node front;
    private Node rear;
    public QueueUsingLinkedList() {
        front = null;
        rear = null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.peek()); // 10
        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek()); // 20
    }

    // Add element to queue
    public void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) { // queue is empty
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Remove element from queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) { // queue became empty
            rear = null;
        }

        return value;
    }

    // View front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Node class for linked list
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}