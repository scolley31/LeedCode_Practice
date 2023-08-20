package org.example;

import java.util.HashSet;



/*
 * Time Complexity O(n)
 * Space Complexity O(k) the number of character aren't repeat
 * */
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Character> hashSet = new HashSet<>();

        while (r < s.length()) {
            if (!hashSet.contains(s.charAt(r))) {
                hashSet.add(s.charAt(r));
                r++;
                max = Math.max(hashSet.size(), max);
            } else {
                hashSet.remove(s.charAt(l));
                l++;
            }
        }


        return max;
    }
}
