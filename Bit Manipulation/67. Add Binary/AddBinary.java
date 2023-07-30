package org.example;


/*
 * Time Complexity O(max(M,N))
 * Space Complexity O(max(M,N))
 * N is count of ListNode
 * */

public class AddBinary {
    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;

        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;
            if (aIndex >= 0) sum += a.charAt(aIndex--) - '0';
            if (bIndex >= 0) sum += b.charAt(bIndex--) - '0';

            if (sum > 1) {
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(sum % 2);
        }

        if (carry == 1) {
            sb.append(carry);
        }


        return sb.reverse().toString();
    }
}
