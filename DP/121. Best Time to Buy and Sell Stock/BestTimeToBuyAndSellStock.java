package org.example;

public class BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int price : prices) {
                int tmpProfit = price - minPrice;
                if (tmpProfit > profit) profit = tmpProfit;
                if (price < minPrice) minPrice = price;
            }
            return profit;
        }
    }
}
