package org.example;


/*
 * Time Complexity O(N)
 * Space Complexity O(1)
 * Where N is Node count of TreeNode
 * */

public class BalancedBinaryTree {

//    my version
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return isBalancedTree(root);
        }

        private boolean isBalancedTree(TreeNode root) {
            if (root == null) return true;
            boolean isBalance = Math.abs(calculateHeightTree(root.right) - calculateHeightTree(root.left)) <= 1;
            return isBalance && isBalancedTree(root.left) && isBalancedTree(root.right);
        }

        private int calculateHeightTree(TreeNode node) {
            if (node == null) return 1;
            return Math.max(1+calculateHeightTree(node.left), 1+calculateHeightTree(node.right));
        }
    }

//    best solution
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            // If the tree is empty, we can say it’s balanced...
            if (root == null) return true;
            // Height Function will return -1, when it’s an unbalanced tree...
            if (Height(root) == -1) return false;
            return true;
        }

        private int Height(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = Height(root.left);
            int rightHeight = Height(root.right);
            if (leftHeight == -1 || rightHeight == -1) return -1;
            if (Math.abs((leftHeight-rightHeight)) > 1) return -1;
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }


}

