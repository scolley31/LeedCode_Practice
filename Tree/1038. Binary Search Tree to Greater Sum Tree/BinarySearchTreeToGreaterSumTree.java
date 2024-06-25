package org.example;

public class BinarySearchTreeToGreaterSumTree {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        int tmp = root.val;
        root.val += sum;
        sum += tmp;
        dfs(root.left);
    }
}
