package org.example;

import javax.management.Query;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildaMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] orderRow = topoSort(rowConditions, k);
        int[] orderCol = topoSort(colConditions, k);
        if (
                orderRow.length == 0 || orderCol.length == 0
        ) return new int[0][0];
        int[][] matrix = new int[k][k];
        for (int i = 0; i < orderRow.length; i++) {
            for (int j = 0; j < orderCol.length; j++) {
                if (orderRow[i] == orderCol[j]) matrix[i][j] = orderRow[i];
            }
        }
        return matrix;
    }

    private int[] topoSort(int[][] edge, int k) {
        int[] degree = new int[k + 1];
        int[] order = new int[k];
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] adj = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            degree[e[1]]++;
        }
        for (int i = 1; i <= k; i++) {
            if (degree[i] == 0) q.offer(i);
        }

        int orderIndex = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            order[orderIndex] = i;
            orderIndex++;
            for (Integer v : adj[i]) {
                if (--degree[v] == 0) q.offer(v);
            }
        }
        if (orderIndex != k) return new int[0];
        return order;
    }
}
