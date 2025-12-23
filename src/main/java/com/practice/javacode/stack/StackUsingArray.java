package com.practice.javacode.stack;

public class StackUsingArray {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor
    public StackUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop()); // 30
        System.out.println(stack.peek()); // 20
    }

    // Add element to stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    // Remove element from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    // Return top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
}

