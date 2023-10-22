package org.example;

import java.util.*;

public class CarFleet {

    /**
     * Time complexity O(NlogN)
     * Space complexity S(N)
     * */
    public int carFleet(int target, int[] position, int[] speed) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], i);
        }

        int[] array = Arrays.stream(position).sorted().toArray();
        for (int r = array.length - 1; r >= 0; r--) {
            if (!stack.isEmpty()) {
                Integer pos = stack.peek();
                double timeTop = (((target - pos) * 1.0) / speed[map.get(pos)]);
                double timePos = (((target - array[r]) * 1.0) / speed[map.get(array[r])]);
                if (timePos > timeTop) stack.push(array[r]);
            } else {
                stack.push(array[r]);
            }
        }
        return stack.size();
    }

    /**
     * Time complexity O(n)
     * Space complexity O(M) M: target length
     * */
    public int carFleet2(int target, int[] position, int[] speed) {
        double[] timeCost = new double[target];
        for (int i = 0; i < position.length; i++) {
            timeCost[position[i]] = (double) (target - position[i]) / (double) speed[i];
        }

        int count = 0;
        double max = 0;
        for (int r = timeCost.length - 1; r >= 0; r--) {
            if (timeCost[r] > max) {
                max = timeCost[r];
                count++;
            }
        }
        return count;
    }

}