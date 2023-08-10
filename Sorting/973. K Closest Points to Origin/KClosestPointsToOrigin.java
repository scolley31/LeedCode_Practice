package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // Quick Sort
    public int[][] kClosest1(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        return Arrays.copyOfRange(points, 0, k);
    }


    // Heap
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = heap.poll();
        }

        return res;
    }

    // Quick Select
    public int[][] kClosest3(int[][] points, int k) {
        int len = points.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == k) break;
            if (mid < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, k);

    }

    private int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && compare(points[r], pivot) >= 0) {
                r--;
                points[l] = points[r];
            }
            while (l < r && compare(points[l], pivot) <= 0) {
                l++;
                points[r] = points[l];
            }
        }
        points[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

}
