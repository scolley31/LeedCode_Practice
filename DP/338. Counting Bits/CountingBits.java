package org.example;

import java.util.Arrays;

public class CountingBits {

    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     * */
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
