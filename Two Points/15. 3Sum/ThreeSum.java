package org.example;

import java.util.*;

public class ThreeSum {


    /**
     * Time Complexity O(n^2)
     * Sort O(nlogn) + iterate nums O(n^2)
     *
     * Space Complexity O(n)
     *
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = target + nums[l] + nums[r];
                    if (sum == 0) {
                        lists.add(Arrays.asList(target, nums[l], nums[r]));

                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }

                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }

                        r--;
                        l++;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return lists;
    }
}
