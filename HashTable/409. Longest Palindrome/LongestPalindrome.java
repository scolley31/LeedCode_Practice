package org.example;


/*
 * Time Complexity O(N)
 * Space Complexity O(1)
 * N is count of String
 * */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] lowercaseArray = new int[26];
        int[] uppercaseArray = new int[26];
        int count = 0;
        boolean countOnlyOne = false;
        boolean countBiggerThanOneOdd = false;

        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            if (c - 'a' >= 0) {
                lowercaseArray[c - 'a']++;
            } else {
                uppercaseArray[c - 'A']++;
            }
        }

        for (int i : lowercaseArray) {
            if(i != 0 && i % 2 == 0) {
                count = count + i;
            } else if (i != 1 && i % 2 == 1 ){
                count = count + i - 1;
                countBiggerThanOneOdd = true;
            } else if (i != 0){
                countOnlyOne = true;
            }
        }

        for (int i : uppercaseArray) {
            if(i != 0 && i % 2 == 0) {
                count = count + i;
            } else if (i != 1 && i % 2 == 1 ){
                count = count + i - 1;
                countBiggerThanOneOdd = true;
            } else if (i != 0){
                countOnlyOne = true;
            }
        }

        if (countOnlyOne || countBiggerThanOneOdd) count++;

        return count;
    }
}
