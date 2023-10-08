package org.example;

public class BestTimeToBuyAndSellStock {
    /**
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * */

    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < prices.length - 1) {
            r++;
            if (prices[r] <= prices[l]) l = r;
            max = Math.max(max, prices[r] - prices[l]);
        }
        return max;
    }
}
