package org.example;

/*
 * Time Complexity O(n)
 * Space Complexity O(1)
 * recursive solution
 *
 * */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode head) {
        if (head == null) return pre;
        ListNode nextNode = head.next;
        head.next = pre;
        return reverse(head, nextNode);
    }
}
