class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int k = people.length - 1;
        int i = 0;
        int count = 0;
        while (i <= k) {
            int num1 = people[k];
            int num2 = people[i];
            if (num1 + num2 <= limit) {
                i++;
            }
            k--;
            count++;
        }
        return count;
    }
}