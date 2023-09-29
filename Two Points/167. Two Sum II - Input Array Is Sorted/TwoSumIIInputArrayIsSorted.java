package org.example;

import java.util.HashMap;

public class TwoSumIIInputArrayIsSorted {


    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * Hash Table
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int remain = target - numbers[i];
            if (maps.containsKey(remain)) {
                return new int[]{maps.get(remain) + 1, i + 1};
            }
            maps.put(numbers[i], i);
        }

        return new int[2];
    }


    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * Two point solution
     */
    public int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l+1, r+1};
            }
        }

        return new int[2];
    }


}
