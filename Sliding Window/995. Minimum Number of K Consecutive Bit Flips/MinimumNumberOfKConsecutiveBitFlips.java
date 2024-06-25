package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumNumberOfKConsecutiveBitFlips {
    public static int minKBitFlips2(int[] nums, int k) {
        int flip = 1;
        int flipCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                flipCount++;
                if (i + k > nums.length) return -1;
                int count = 0;
                while (count < k) {
                    nums[i + count] ^= flip;
                    count++;
                }
            }
        }
        return flipCount;
    }

    public static int minKBitFlips(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int flipCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && (i - queue.peekFirst() + 1) > k) {
                queue.pollFirst();
            }

            if ((nums[i] + queue.size()) % 2 == 0) {
                if (i + k > nums.length) return -1;
                flipCount++;
                queue.add(i);
            }

        }

        return flipCount;
    }
}
