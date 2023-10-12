package org.example;

import java.util.HashMap;

public class MinimumWindowSubstring {


    /**
     * Time complexity O(n + m) String s length and String t length
     * Space complexity O(n)
     * */

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int match = 0;
        int start = 0;
        int minLength = s.length() + 1;
        int subStringStart = 0;
        int end = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) == 0) {
                    match++;
                }
            }

            while (match == map.size()) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    subStringStart = start;
                }
                char del = s.charAt(start);
                start++;
                if (map.containsKey(del)) {
                    if (map.get(del) == 0) {
                        match--;
                    }
                    map.put(del, map.get(del) + 1);
                }
            }
            end++;
        }

        return minLength > s.length() ? "" : s.substring(subStringStart, subStringStart + minLength);
    }
}
