package org.example;

import java.util.*;

public class TopKFrequentElements {


    /**
     * Time complexity O(N)
     * Space complexity S(N)
     * N = nums length
     * <p>
     * Bucket sort
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int f = map.get(key);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(key);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null && list.size() < k && !bucket[i].isEmpty()) {
                list.addAll(bucket[i]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     *
     * Time complexity 0(KLog(N))
     * Space complexity S(N)
     *
     * Max heap
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        heap.addAll(map.entrySet());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            res.add(entry.getKey());
        }

        return res.stream().mapToInt(i -> i).toArray();
    }


    /**
     *
     * Time complexity 0(NLog(N))
     * Space complexity S(N)
     *
     * Array sort method
     */
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> (b.getValue() - a.getValue()));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = entryList.get(i).getKey();
        }

        return res;
    }


}
