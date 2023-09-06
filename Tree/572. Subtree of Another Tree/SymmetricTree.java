package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    /**
     * recursive
     * Time complexity O(n)
     * Space complexity O(1)
     * */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        boolean isMirror = isMirror(root.left, root.right);
        return isMirror;
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }


    /**
     * iterative
     * Time complexity O(n)
     * Space complexity O(n)
     *
     * By Queue
     * */

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.add(root.right);
        queue.add(root.left);

        while (!queue.isEmpty()) {
            TreeNode r = queue.poll();
            TreeNode l = queue.poll();
            if (r == null && l == null) continue;
            if (r == null || l == null) return false;
            if (r.val != l.val) return false;
            queue.add(r.right);
            queue.add(l.left);
            queue.add(r.left);
            queue.add(l.right);
        }
        return true;

    }




}
