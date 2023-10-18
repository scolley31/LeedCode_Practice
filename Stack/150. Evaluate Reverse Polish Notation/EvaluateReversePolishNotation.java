package org.example;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("+") &&
                !tokens[i].equals("-") &&
                !tokens[i].equals("*") &&
                !tokens[i].equals("/")) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                int first = stack.pop();
                int second = stack.pop();
                int ans = 0;
                if (tokens[i].equals("+")) {
                    ans = second + first;
                } else if (tokens[i].equals("-")) {
                    ans = second - first;
                } else if (tokens[i].equals("*")) {
                    ans = second * first;
                } else {
                    ans = second / first;
                }
                stack.push(ans);
            }
        }
        return stack.peek();
    }
}
