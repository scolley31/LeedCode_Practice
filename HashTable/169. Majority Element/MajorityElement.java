package org.example;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

    /*
     * Time Complexity O(N)
     * Space Complexity O(N)
     * Using Hashmap to record the count of element
     * */
    public int majorityElement(int[] nums) {
        int maxCount = 0;
        int maxNumber = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int originNumber = map.getOrDefault(num, 1);
            if (originNumber+1 > maxCount) {
                maxCount = originNumber + 1;
                maxNumber = num;
            }
            map.put(num, originNumber+1);
        }

        return maxNumber;
    }

    /*
     * Time Complexity O(N)
     * Space Complexity O(1)
     * Using Hashmap to record the count of element
     * */
    public int majorityElement2(int[] nums) {
        int count = 0;
        int register = 0;
        for (int num : nums) {
            if (count == 0) register = num;
            if (register == num) {
                count++;
            } else {
                count--;
            }
        }

        return register;
    }
}
