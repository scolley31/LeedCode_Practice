package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementInAnArray {

    //quick sort
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //heap
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    //quick select
    public static int findKthLargest3(int[] nums, int k) {
        quickSelect(nums,0 ,nums.length - 1, k);
        return nums[k-1];
    }

    private static void quickSelect(int[] nums, int start, int end, int k) {
        int n = 0;
        int index = k - 1;
        while (start <= end) {
            n = partition(nums, start, end);
            if (n == index) {
                break;
            } else if (n > index) {
                end = n - 1;
            } else {
                start = n + 1;
            }
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int n = start;
        for (int i = start; i < end; i++) {
            if (pivot < nums[i]) {
                swap(nums, i, n);
                n++;
            }
        }
        swap(nums, n, end);
        return n;
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
