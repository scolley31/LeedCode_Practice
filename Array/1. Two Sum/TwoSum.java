package org.example;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            int[] twoSumArrayIndex = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int remainInt = target - nums[i];
                if (numMap.containsKey(nums[i])) {
                    twoSumArrayIndex[0] = numMap.get(nums[i]);
                    twoSumArrayIndex[1] = i;
                    break;
                } else {
                    numMap.put(remainInt, i);
                }
            }
            return twoSumArrayIndex;
        }
    }
}
