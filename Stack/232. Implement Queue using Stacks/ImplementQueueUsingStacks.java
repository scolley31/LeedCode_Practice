package org.example;

import java.util.Stack;


public class ImplementQueueUsingStacks {

    /*
     * Time Complexity O(1)
     * Space Complexity O(N)
     * Make Queue by LinkedList
     * */
    class MyQueue {

        ListNode head;
        ListNode last;
        int size;
        public MyQueue() {

        }

        public void push(int x) {
            if (size == 0) {
                head = new ListNode(x);
                last = head;
                size++;
                return;
            }
            last.next = new ListNode(x);
            last = last.next;
            size++;
        }

        public int pop() {
            int popItem = head.val;
            head = head.next;
            size--;
            return popItem;
        }

        public int peek() {
            return head.val;
        }

        public boolean empty() {
            return size == 0;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * Time Complexity O(1)
     * Space Complexity O(N)
     * Make Queue by Stack
     * */
    class MyQueue2 {

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        public MyQueue2() {

        }

        public void push(int x) {
            inputStack.push(x);
        }

        public int pop() {
            peek();
            return outputStack.pop();
        }

        public int peek() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.peek();
        }

        public boolean empty() {
            return outputStack.isEmpty() && inputStack.isEmpty();
        }
    }
}
