package org.example;

public class ReorderList {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     * */
    public void reorderList(ListNode head) {

        // Find the middle node
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse List and create the second node
        ListNode pre = null;
        ListNode second = slow.next;
        slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = pre;
            pre = second;
            second = tmp;
        }

        // merge two sort
        ListNode first = head;
        second = pre;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

    }
}
