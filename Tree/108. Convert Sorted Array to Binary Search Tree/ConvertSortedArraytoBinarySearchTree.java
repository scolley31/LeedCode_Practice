package org.example;

public class ConvertSortedArraytoBinarySearchTree {

    /*
     * Time Complexity O(n)
     * Space Complexity O(n) in memory
     * */
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBSTTree(nums, 0, nums.length - 1);
    }

    private TreeNode createBSTTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.right = createBSTTree(nums, mid + 1, right);
        node.left = createBSTTree(nums, left, mid -1 );
        return node;
    }

}
