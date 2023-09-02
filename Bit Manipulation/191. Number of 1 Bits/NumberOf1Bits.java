package org.example;

public class NumberOf1Bits {
    // you need to treat n as an unsigned value

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * */
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            num = num + (n & 1);
            n = n >>>1;
        }
        return num;
    }
}
