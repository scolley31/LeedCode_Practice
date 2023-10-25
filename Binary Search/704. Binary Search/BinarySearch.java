package org.example;


/*
 * Time Complexity O(log(n))
 * Space Complexity O(1)
 * */

public class BinarySearch {

    // recursive
    public int search2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l)/2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, l, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, r);
        }
    }

    // iterative
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return  mid;
            }
        }
        return -1;
    }
}
