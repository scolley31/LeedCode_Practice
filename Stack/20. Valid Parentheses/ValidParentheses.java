package org.example;

import java.util.Stack;

public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> isValidStack = new Stack<>() ;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {

                switch (aChar) {
                    case '(', '[', '{' -> isValidStack.push(aChar);
                    case ')' -> {
                        if (isValidStack.isEmpty()) return false;
                        if (isValidStack.pop() != '(') {
                            return false;
                        }
                    }
                    case ']' -> {
                        if (isValidStack.isEmpty()) return false;
                        if (isValidStack.pop() != '[') {
                            return false;
                        }
                    }
                    case '}' -> {
                        if (isValidStack.isEmpty()) return false;
                        if (isValidStack.pop() != '{') {
                            return false;
                        }
                    }
                }
            }
            return  isValidStack.isEmpty();
        }
    }
}
