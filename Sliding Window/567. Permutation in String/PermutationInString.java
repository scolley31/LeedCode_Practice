package org.example;

import java.util.Arrays;

public class PermutationInString {

    /**
     * my version
     *
     * Time complexity O(26*n)
     * Space complexity O(1)
     *
     * */
    public static boolean checkInclusion(String s1, String s2) {
        int[] charsS1 = new int[26];

        int i = 0;
        while (i < s1.length()) {
            charsS1[s1.charAt(i) - 'a']++;
            i++;
        }

        int j = 0;
        int l = 0;
        while (j < s2.length()) {
            charsS1[s2.charAt(j) - 'a']--;
            while (Arrays.stream(charsS1).allMatch(count -> count <= 0)) {
                if (j - l + 1 == s1.length()) {
                    return true;
                }
                charsS1[s2.charAt(l) - 'a']++;
                l++;
            }
            j++;

        }
        return false;
    }

    /**
     *
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * */

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] charsS1 = new int[26];
        int[] charsS2 = new int[26];

        int i = 0;
        while (i < s1.length()) {
            charsS1[s1.charAt(i) - 'a']++;
            charsS2[s2.charAt(i) - 'a']++;
            i++;
        }

        if (Arrays.equals(charsS1, charsS2)) return true;

        int r = s1.length();
        int l = 0;

        for (int k = r; k < s2.length(); k++) {
            charsS2[s2.charAt(k) - 'a']++;
            charsS2[s2.charAt(l) - 'a']--;
            if (Arrays.equals(charsS1, charsS2)) return true;
            l++;
        }
        return false;
    }
}
