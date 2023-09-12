package org.example;

public class PalindromeNumber {

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * */
    public static boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int result = 0;
        int originNumber = x;
        while (originNumber > 0) {
            int res = originNumber % 10;
            originNumber = originNumber/10;
            result *= 10;
            result += res;
        }

        return (result == x);
    }

}
