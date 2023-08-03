package org.example;

import java.util.HashMap;


/*
 * Time Complexity O(n)
 * Space Complexity O(n)
 * */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashNum = new HashMap<>();

        for (int num : nums) {
            if (hashNum.containsKey(num)) {
                return true;
            }
            hashNum.put(num, 1);
        }
        return false;
    }
}
