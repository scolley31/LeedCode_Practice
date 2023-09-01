package org.example;

public class SameTree {
    /**
     * Time complexity O(min(N,M)
     * Space complexity O(min(H1,H2))
     *
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

}
