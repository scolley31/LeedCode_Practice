package org.example;

public class MissingNumber {


    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * */
    public static int missingNumber(int[] nums) {
        int h = nums.length;
        int sum = ((0+h) * (h+1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return sum - actualSum;

    }


    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * */
    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }


}
