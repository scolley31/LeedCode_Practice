package org.example;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int zeroPoint = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                change(nums, i , zeroPoint);
                zeroPoint++;
            }
            i++;
        }
    }

    private void change(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
