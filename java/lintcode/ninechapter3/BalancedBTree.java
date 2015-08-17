package lintcode.ninechapter3;

/**
 * Created by jun on 8/17/2015.
 */
public class BalancedBTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        try {
            getTreeDepth(root);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private int getTreeDepth(TreeNode node) throws Exception {
        if (node == null) {
            return 0;
        }

        int left = getTreeDepth(node.left);
        int right = getTreeDepth(node.right);

        if (Math.abs(left - right) > 1) {
            throw new Exception("not balanced");
        }

        return Math.max(left, right) + 1;
    }
}
