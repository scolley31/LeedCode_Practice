package org.example;

public class SortColors {

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * Dutch National Flag Problem
     *
     * one pass
     * */

    public void sortColors1(int[] nums) {
        int s = 0;
        int m = 0;
        int e = nums.length - 1;
        while (m <= e) {
            if (nums[m] == 0) {
                swap(nums, s, m);
                s++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else {
                swap(nums, m, e);
                e--;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * Counting sort
     *
     * 2-pass
     * */

    public void sortColors2(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (i < zero + one) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

}
