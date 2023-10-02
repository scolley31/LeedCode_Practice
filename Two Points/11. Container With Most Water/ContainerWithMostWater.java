package org.example;

public class ContainerWithMostWater {


    /**
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * */

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int max = 0;
        while (l < r) {
            int minHeight = Math.min(height[l] , height[r]);
            int totalWater = minHeight * (r - l);
            max = Math.max(max, totalWater);
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }
}
