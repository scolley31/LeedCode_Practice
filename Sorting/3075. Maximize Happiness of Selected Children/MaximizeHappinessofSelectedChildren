class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        int decrease = 0;
        Arrays.sort(happiness);
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            int num = happiness[i] - decrease;
            if (num >= 0) {
                sum += num;
            }
            decrease++;
        }
        return sum;
    }
}