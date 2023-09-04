package org.example;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     *
     *
     * XOR
     *
     * */

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
           ans = ans ^ num;
        }
        return ans;
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     *
     * Hashmap
     *
     * */
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            Integer count = hashMap.getOrDefault(num, 0);
            hashMap.put(num, ++count);
        }
        Integer singleNumber = 0;
        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                singleNumber = entry.getKey();
            }
        }
        return singleNumber;
    }





}
