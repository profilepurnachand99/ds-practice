package com.practice.javacode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q = new LinkedList<>();

    // Push operation (costly)
    public void push(int x) {
        q.add(x);

        // Rotate previous elements behind the new one
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    // Pop operation (efficient)
    public int pop() {
        if (q.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.remove();
    }

    // Peek top element
    public int top() {
        if (q.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return q.peek();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop()); // 30
        System.out.println(s.top()); // 20
        System.out.println(s.pop()); // 20
    }
}
