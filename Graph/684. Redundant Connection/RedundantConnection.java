package org.example;

public class RedundantConnection {
    int[] par;

    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            } else {
                union(edge[0], edge[1]);
            }
        }
        return new int[]{-1, -1};
    }

    private void union(int n, int m) {
        int root1 = find(par[n]);
        int root2 = find(par[m]);
        if (root2 != root1) {
            par[root1] = root2;
        }
    }

    private int find(int n) {
        while (n != par[n]) {
            n = par[n];
        }
        return n;
    }
}
