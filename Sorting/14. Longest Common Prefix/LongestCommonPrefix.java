package org.example;

import java.util.Arrays;

public class LongestCommonPrefix {


    /**
     * Time Complexity O(nLog(n)+ m)
     * Space Complexity O(1)
     * 
     * */
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                stringBuilder.append(s1.charAt(i));
            } else {
                break;
            }
            i++;
        }
        return stringBuilder.toString();
    }
}
