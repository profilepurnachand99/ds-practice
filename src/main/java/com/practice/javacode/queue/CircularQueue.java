package com.practice.javacode.queue;

public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.dequeue()); // 10
        q.enqueue(60); // wraps around
        System.out.println(q.peek()); // 20
    }

    // Insert element
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    // Remove element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
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
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
