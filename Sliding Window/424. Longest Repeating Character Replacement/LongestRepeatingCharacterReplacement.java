package org.example;

public class LongestRepeatingCharacterReplacement {


   /**
    *
    * Time complexity O(n)
    * Space complexity O(1)
    *
    * */
    public static int characterReplacement(String s, int k) {
        int r = 0;
        int l = 0;
        int count = 0;
        int[] freq = new int[26];
        int max = 0;

        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            max = Math.max(max, freq[s.charAt(r) - 'A']);

            if (r - l + 1 - max > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            count = Math.max(count, r - l + 1);
            r++;

        }

        return count;
    }
}
