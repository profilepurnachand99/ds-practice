package com.practice.javacode.queue;

public class LinearQueueUsingArray {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    public LinearQueueUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
    }

    public static void main(String[] args) {
        LinearQueueUsingArray q = new LinearQueueUsingArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.peek()); // 10
        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek()); // 20
    }

    // Add element to queue
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = x;
    }

    // Remove element from queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front++];
    }

    // View front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }
}
