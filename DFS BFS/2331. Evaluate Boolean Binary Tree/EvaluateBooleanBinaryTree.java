public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        return checkValue(root);
    }

    private boolean checkValue(TreeNode node) {

        switch (node.val) {
            case 0 -> {
                return false;
            }
            case 1 -> {
                return true;
            }
            case 2 -> {
                return checkValue(node.left) || checkValue(node.right);
            }
            case 3 -> {
                return checkValue(node.left) && checkValue(node.right);
            }
        }
        return false;
    }
}
