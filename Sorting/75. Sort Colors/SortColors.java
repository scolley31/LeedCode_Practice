package org.example;

import java.util.Arrays;

public class SortColors {

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     * Dutch National Flag Problem
     * */

    public void sortColors(int[] nums) {
        int s = 0;
        int m = 0;
        int e = nums.length -1;
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

}
