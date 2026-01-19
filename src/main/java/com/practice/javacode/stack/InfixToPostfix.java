package com.practice.javacode.stack;

import java.util.Stack;

public class InfixToPostfix {

    // Function to return precedence of operators
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String convert(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infix.toCharArray()) {

            // 1. Operand → add to output
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }

            // 2. '(' → push
            else if (ch == '(') {
                stack.push(ch);
            }

            // 3. ')' → pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }

            // 4. Operator
            else {
                while (!stack.isEmpty() &&
                        precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 5. Pop remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "A+(B*C-(D/E^F)*G)*H";
        System.out.println(convert(infix));
    }
}

