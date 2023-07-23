package org.example;

/*
 * Time Complexity O(n)
 * Space Complexity O(1)
 * */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCountArray = new int[26];
        for (char m : magazine.toCharArray()) {
            charCountArray[m - 'a'] = charCountArray[m - 'a'] + 1;
        }
        for (char r : ransomNote.toCharArray()) {
            charCountArray[r - 'a'] = charCountArray[r - 'a'] - 1;
        }
        for (int c : charCountArray) {
            if (c < 0) return false;
        }
        return true;
    }
}
