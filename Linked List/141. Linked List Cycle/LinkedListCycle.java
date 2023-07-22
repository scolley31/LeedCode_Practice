package org.example;


/*
 * Time Complexity O(N)
 * Space Complexity O(1)
 * N is count of ListNode
 * */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode slowNode = head;
        ListNode fastNode = head;

        while (true) {
            if (fastNode.next == null || fastNode.next.next == null) return false;
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) return true;
        }

    }
}
