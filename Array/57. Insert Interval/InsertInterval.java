package org.example;

import java.util.ArrayList;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        ArrayList<int[]> finalInterval = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                finalInterval.add(interval);
            } else if (interval[0] > newInterval[1]) {
                finalInterval.add(newInterval);
                newInterval = interval;
            } else if (interval[1] >= newInterval[0] || interval[0] <= newInterval[0]) {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        finalInterval.add(newInterval);

        return finalInterval.toArray(new int[finalInterval.size()][]);

    }
}
