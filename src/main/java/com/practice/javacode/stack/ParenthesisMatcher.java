package com.practice.javacode.stack;

import java.util.Stack;

public class ParenthesisMatcher {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Handle closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If stack is empty → no matching opening bracket
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // Check if the pair matches
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // If stack is empty → all brackets matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";
        System.out.println(isValid(s));  // true
    }
}