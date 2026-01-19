package com.practice.javacode.stack;

import java.util.Stack;

public class PostfixEvaluation {

    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            // Skip spaces
            if (ch == ' ') continue;

            // If operand → push to stack
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');  // convert char to int
            }

            // If operator → pop two values and apply
            else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expr = "231*+9-";  // Example
        System.out.println(evaluate(expr));  // Output: -4
    }
}
