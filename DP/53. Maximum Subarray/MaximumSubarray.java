package org.example;

/*
 * Kadane's Algorithm
 * Time Complexity O(N)
 * Space Complexity O(N)
 *
 * */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxNumber = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            maxNumber = Math.max(dp[i], maxNumber);
        }

        return maxNumber;
    }

/*
 * Kadane's Algorithm
 * Time Complexity O(N)
 * Space Complexity O(1)
 *
 * */

    public int maxSubArray2(int[] nums) {
        int maxNumber = nums[0];
        int tmpMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tmpMax = Math.max(tmpMax + nums[i], nums[i]);
            if (tmpMax > maxNumber) maxNumber = tmpMax;
        }
        return maxNumber;
    }
}
