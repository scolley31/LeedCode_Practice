package org.example;

public class FindMinimumInRotatedSortedArray {

    /**
     * Time complexity O(log(n))
     * Space complexity S(1)
     * */
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {

            if (nums[l] < nums[r]) {
                return nums[l];
            }

            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[r];
    }
}
