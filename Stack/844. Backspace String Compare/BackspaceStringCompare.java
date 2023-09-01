package org.example;

import java.util.Stack;

public class BackspaceStringCompare {

    /*
     * Time Complexity O(N+M)
     * Space Complexity O(N+M)
     * */
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            } else {
                stackS.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            } else {
                stackT.push(t.charAt(i));
            }
        }

        if (stackT.isEmpty() && !stackS.isEmpty()) return false;
        if (!stackT.isEmpty() && stackS.isEmpty()) return false;

        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackT.pop() != stackS.pop()) return false;
            if (stackT.isEmpty() && !stackS.isEmpty()) return false;
            if (!stackT.isEmpty() && stackS.isEmpty()) return false;
        }
        return true;
    }
}
