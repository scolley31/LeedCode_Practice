package org.example;

import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     *
     * */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        int max = 0;

        for (int num : nums) {
           sets.add(num);
        }

        for (Integer set : sets) {
            if (!sets.contains(set - 1)) {
                int m = set + 1;
                while (sets.contains(m)) {
                    m++;
                }
                max = Math.max(max, m - set);
            }
        }
        return max;
    }
}
