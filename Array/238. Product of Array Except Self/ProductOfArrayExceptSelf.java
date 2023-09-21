package org.example;

public class ProductOfArrayExceptSelf {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * <p>
     * my own version of prefix algorithm
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] prefixLeft = new int[nums.length];
        int[] prefixRight = new int[nums.length];
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixLeft[i] = 1;
            prefixRight[i] = 1;
            ans[i] = 1;
        }
        prefixLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixLeft[i] = prefixLeft[i - 1] * nums[i];
        }
        prefixRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = prefixRight.length - 2; i >= 0; i--) {
            prefixRight[i] = prefixRight[i + 1] * nums[i];
        }
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                ans[i] = prefixRight[i + 1];
            } else if (i == ans.length - 1) {
                ans[i] = prefixLeft[i - 1];
            } else {
                ans[i] = prefixLeft[i - 1] * prefixRight[i + 1];
            }
        }

        return ans;
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * <p>
     * from solutions
     *
     * */
    public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            if (i < res.length -1) r = r*nums[i+1];
            res[i] *= r;
        }
        return res;

    }

}
