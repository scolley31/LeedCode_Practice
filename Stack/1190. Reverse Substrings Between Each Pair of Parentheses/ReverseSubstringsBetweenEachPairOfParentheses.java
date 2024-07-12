package org.example;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int index = stack.pop();
                s = reverseString(s, index + 1, i - 1);
            }
        }
        s = s.replace("(", "");
        s = s.replace(")", "");
        return s;
    }

    private String reverseString(String s, int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i>=a && i <= b) {
                int n = i - a;
                char c = s.charAt(b-n);
                stringBuilder.append(c);
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
