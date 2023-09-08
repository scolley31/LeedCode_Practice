package org.example;

import java.util.Arrays;

public class SquaresofaSortedArray {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * Brute Force Approach
     */
    public int[] sortedSquares(int[] nums) {
        int[] newNUms = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNUms[i] = nums[i] * nums[i];
        }
        Arrays.sort(newNUms);
        return newNUms;
    }


    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * Two points Approach
     */
    public int[] sortedSquares2(int[] nums) {
        int[] newNums = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                newNums[index] = nums[left] * nums[left];
                left++;
            } else {
                newNums[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return newNums;
    }


}
