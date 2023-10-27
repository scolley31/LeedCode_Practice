package org.example;

public class KokoEatingBananas {

    /**
     * n pile's length
     * max piles max
     * Time complexity O(n*log(max))
     * Space complexity O(1)
     * */
    public  int minEatingSpeed(int[] piles, int h) {
        int r = 1000000000;
        int l = 1;
        for (int pile : piles) {
            r = Math.max(pile, r);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long times = 0;
            for (int pile : piles) {
                times = times + pile / mid;
                if (pile % mid != 0) times++;
            }
            if (times <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
