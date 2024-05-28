public class GetEqualSubstringsWithinBudget {
    public static int equalSubstring(String s, String t, int maxCost) {

        int right = 0;
        int left = 0;
        int max = 0;
        int tmpMax = 0;

        for (right = 0; right < s.length(); right++) {
            tmpMax++;
            maxCost -= Math.abs(s.charAt(right) - t.charAt(right));
            while (maxCost < 0 && left < right) {
                tmpMax--;
                maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            max = Math.max(max, tmpMax);

        }

        return max;
    }
}