package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
     * Time Complexity O(nLog(n))
     * Space Complexity O(1)
     *
     * Approach 1: Sorting
     *
     * Explanation: after sorting array, transfer to string and compare whether equal
     * This is low efficiency because of twice transformation.
     * Beat 35%
     * */

    class Solution1 {
        public boolean isAnagram(String s, String t) {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);

            return Arrays.toString(charT).equals(Arrays.toString(charS));
        }
    }

    /*
     * Time Complexity O(nLog(n))
     * Space Complexity O(1)
     *
     * Approach 1: Sorting
     *
     * Explanation: after sorting array, directly to compare value of char[].
     * Beat 86%
     * */

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);
            int point = 0;
            if (charS.length != charT.length) return false;
            while (point <= charS.length - 1) {
                if (charS[point] != charT[point]) return false;
                point++;
            }
            return true;
        }
    }

    class Solution3 {
        public boolean isAnagram(String s, String t) {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            Arrays.sort(charS);
            Arrays.sort(charT);
            return Arrays.equals(charS, charT);
        }
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * Approach 2: Hash Table
     *
     * Explanation: create a hash table to put every char. key is char and value is frequency.
     * When every char put in map, value of frequency add one times.
     * Finally, check every value of hash table.
     * Can support Unicode characters.
     * Beat 29%
     * */

    class Solution4 {
        public boolean isAnagram(String s, String t) {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            if (charS.length != charT.length) return false;
            HashMap<Character, Integer> map = new HashMap<>();
            for (char aChar : charS) {
                if (map.get(aChar) != null) {
                    int count = map.get(aChar);
                    count++;
                    map.put(aChar, count);
                } else {
                    map.put(aChar, 1);
                }
            }
            for (char c : charT) {
                if (map.get(c) == null) {
                    return false;
                }
                int count = map.get(c);
                count--;
                map.put(c, count);
            }

            for (int value : map.values()) {
                if (value != 0) return false;
            }
            return true;
        }
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * Approach 2: Hash Table
     *
     * Explanation: create a array to put every char. And the value is frequency.
     * Can't support Unicode characters.
     * Beat 99%
     * */
    class Solution5 {
        public boolean isAnagram(String s, String t) {
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            if (charS.length != charT.length) return false;
            int[] countArray = new int[26];
            for (char aChar : charS) {
                countArray[aChar - 'a']++;
            }
            for (char bChar : charT) {
                countArray[bChar - 'a']--;
            }
            for (int i : countArray) {
                if (i != 0) return false;
            }
            return true;
        }
    }
}
