package org.example;

import java.util.ArrayList;

public class BalanceABinarySearchTree {
    ArrayList<TreeNode> lists = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrderDFS(root);
        return binarySearchTree(0, lists.size() - 1);
    }

    private TreeNode binarySearchTree(int l, int r) {
        if (l > r) return null;
        int m = (l + r) /2;
        TreeNode root = lists.get(m);
        root.left = binarySearchTree(l, m - 1);
        root.right = binarySearchTree(m + 1, r);
        return root;
    }

    private void inOrderDFS(TreeNode node) {
        if (node == null) return;
        inOrderDFS(node.left);
        lists.add(node);
        inOrderDFS(node.right);
    }
}
