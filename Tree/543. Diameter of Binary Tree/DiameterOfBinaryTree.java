package org.example;

public class DiameterOfBinaryTree {

    /*
     * Time Complexity O(n)
     * Space Complexity O(1)
     * */
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        longestDiameter(root);
        return maxDiameter;
    }

    private int longestDiameter(TreeNode node) {
        if (node == null) return 0;
        int right = longestDiameter(node.right);
        int left = longestDiameter(node.left);
        int totalNodeDiameter = right + left;

        if (totalNodeDiameter > maxDiameter) maxDiameter = totalNodeDiameter;

        return 1 + Math.max(right, left);
    }


}
