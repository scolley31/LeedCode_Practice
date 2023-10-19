package org.example;

import java.util.Stack;

public class DailyTemperatures {

    /**
     * Time complexity O(n)
     * Space complexity S(n)
     * */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stackIndex = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stackIndex.isEmpty() && temperatures[stackIndex.peek()] < temperatures[i]) {
                int index = stackIndex.pop();
                ans[index] = i - index;
            }
            stackIndex.push(i);
        }
        return ans;
    }
}
