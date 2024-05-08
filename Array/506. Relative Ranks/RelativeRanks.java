class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] originScore = score.clone();
        String[] ans = new String[originScore.length];
        Arrays.sort(score);
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = score.length - 1; i >= 0; i--) {
            if (i == score.length - 1) {
                map.put(score[i], "Gold Medal");
            } else if (i == score.length - 2) {
                map.put(score[i], "Silver Medal");
            } else if (i == score.length - 3) {
                map.put(score[i], "Bronze Medal");
            } else {
                map.put(score[i], String.valueOf(score.length - i));
            }
        }

        for (int i = 0; i < originScore.length; i++) {
            String rank = map.get(originScore[i]);
            ans[i] = rank;
        }
        return ans;
    }
}