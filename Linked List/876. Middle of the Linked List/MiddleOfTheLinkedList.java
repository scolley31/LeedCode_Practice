package org.example;

import java.util.ArrayList;

public class MiddleOfTheLinkedList {

    /*
     * Time Complexity O(n)
     * Space Complexity O(n)
     *
     * */

    public ListNode middleNode(ListNode head) {

        ArrayList<ListNode> listNode = new ArrayList<>();

        while (head != null) {
            listNode.add(head);
            head = head.next;
        }

        int middleIndex = listNode.size() / 2;
        return listNode.get(middleIndex);
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * Recursive
     * */

    public ListNode middleNode2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        return findMiddle(head.next, head.next.next);
    }

    private ListNode findMiddle(ListNode slow, ListNode first) {
        if (first.next == null) {
            return slow;
        }
        if (first.next.next == null) {
            return slow.next;
        }
        first = first.next.next;
        slow = slow.next;
        return findMiddle(slow, first);
    }

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * Iterative
     * */

    public ListNode middleNode3(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
