package org.example;

/*
 * Time Complexity O(n)
 * Space Complexity O(1)
 * */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int n1 = 1;
        int n2 = 2;
        int step = 0;
        for (int i = 2; i < n; i++) {
            step = n1 + n2;
            n1 = n2;
            n2 = step;
        }
        return step;
    }
}
