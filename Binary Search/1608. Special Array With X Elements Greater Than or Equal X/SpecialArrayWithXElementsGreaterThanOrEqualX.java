public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static int specialArray(int[] nums) {
        int l = 0;
        int r = 100;

        while (l <= r) {
            int x = (l + r)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= x) count++;
            }


            if (count == x) {
                return x;
            } else if (count > x) {
                l = x;
            } else {
                r = x;
            }

        }

        return -1;
    }
}