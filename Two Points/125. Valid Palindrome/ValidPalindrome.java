package org.example;

import java.util.Stack;


public class ValidPalindrome {

    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     * */

    class Solution {
        public boolean isPalindrome(String s) {
            String string = s;
            Stack<Character> stack = new Stack<>();
            int beginToPop;
            boolean isOdd;

            string = string.toLowerCase();
            string = string.replaceAll("[^a-z0-9]", "");

            if (string.isEmpty()) return true;

            char[] charsList = string.toCharArray();
            if (charsList.length % 2 == 0) {
                isOdd = true;
                beginToPop = charsList.length / 2;
            } else {
                isOdd = false;
                beginToPop = charsList.length / 2 + 1;
            }

            for (int i = 0; i < beginToPop; i++) {
                stack.push(charsList[i]);
            }

            if (!isOdd) {
                stack.pop();
            }


            for (int i = beginToPop; i < charsList.length; i++) {
                if (stack.peek() == charsList[i]) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }


    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * */

    class Solution2 {
        public boolean isPalindrome(String s) {
            String string = s;
            string = string.toLowerCase();
            string = string.replaceAll("[^a-z0-9]", "");
            char[] chars = string.toCharArray();
            int pointA = 0;
            int pointB = chars.length - 1;

            if (string.isEmpty()) return true;

            if (chars.length % 2 == 0) {
                while (pointA - 1 < pointB) {
                    if (chars[pointA] == chars[pointB]) {
                        pointA++;
                        pointB--;
                    } else {
                        return false;
                    }
                }
            } else {
                while (pointA < pointB) {
                    if (chars[pointA] == chars[pointB]) {
                        pointA++;
                        pointB--;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * */

    class Solution3 {
        public boolean isPalindrome(String s) {
            String string = s;
            char[] chars = string.toCharArray();
            int pointA = 0;
            int pointB = chars.length - 1;

            if (string.isEmpty()) return true;

            while (pointA < pointB) {
                char charA = chars[pointA];
                char charB = chars[pointB];
                if (!Character.isLetterOrDigit(charA)) {
                    pointA++;
                } else if (!Character.isLetterOrDigit(charB)) {
                    pointB--;
                } else if (Character.toLowerCase(charA) != Character.toLowerCase(charB)) {
                    return false;
                } else {
                    pointA++;
                    pointB--;
                }
            }
            return true;
        }
    }
}
