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
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quickSelect(int[][] points, int start, int end, int k) {
        while (start <= end) {
            if (start == end) {
                return;
            }
            int pIndex = partition(points , start, end);
            if (pIndex < k) {
                start = pIndex + 1;
            } else if (pIndex > k) {
                end = pIndex - 1;
            } else {
                return;
            }
        }
    }

    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (dis(points[i]) <= dis(pivot)) {
                swap(points, i, pIndex);
                pIndex++;
            }
        }
        swap(points, pIndex, end);
        return pIndex;
    }
    private void swap(int[][] a, int x, int y) {
        int[] temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private int dis(int[] x) {
        return x[0]*x[0] + x[1]*x[1];
    }

}
