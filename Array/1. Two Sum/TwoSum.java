package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     */

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            int[] twoSumArrayIndex = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int remainInt = target - nums[i];
                if (numMap.containsKey(nums[i])) {
                    return new int[]{numMap.get(nums[i]), i};
                } else {
                    numMap.put(remainInt, i);
                }
            }
            return new int[]{};
        }
    }
}
