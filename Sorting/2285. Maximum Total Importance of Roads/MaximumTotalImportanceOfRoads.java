package org.example;

import java.util.Arrays;

public class MaximumTotalImportanceOfRoads {

    public static long maximumImportance(int n, int[][] roads) {
        int[] nums = new int[n];
        for (int[] road : roads) {
            for (int i : road) {
                nums[i]++;
            }
        }
        Arrays.sort(nums);
        long max = 0;
        for (int i = 0; i <= n - 1; i++) {
            long count = nums[i];
            max += count * (i + 1);
        }
        return max;
    }

}
