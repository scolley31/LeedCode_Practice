package org.example;

import java.util.ArrayList;

public class PalindromeLinkedList {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     * brute force method
     */
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != arrayList.get(arrayList.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public static boolean isPalindrome2(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       ListNode pre = slow;
       ListNode cur = slow.next;
       pre.next = null;
       while (cur != null ) {
           ListNode tmp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = tmp;
       }

       ListNode begin = head;
       while (pre != null) {
           if (pre.val != begin.val) {
               return false;
           }
           pre = pre.next;
           begin = begin.next;
       }
       return true;
    }

}
