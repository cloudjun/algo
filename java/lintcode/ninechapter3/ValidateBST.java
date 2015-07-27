package lintcode.ninechapter3;

/**
 * Created by jun on 7/26/2015.
 */

class ResultType {
    boolean isBST;
    TreeNode min;
    TreeNode max;

    public ResultType(boolean isBST, TreeNode min, TreeNode max) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
    }

    public boolean isNull() {
        return min == null && max == null;
    }
}

public class ValidateBST {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private int lastVal = Integer.MIN_VALUE;
    private boolean firstNode = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!firstNode && lastVal >= root.val) {
            return false;
        }
        firstNode = false;
        lastVal = root.val;
        return isValidBST(root.right);
    }

//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        return checkValidBST_DC(root).isBST;
//    }

    private ResultType checkValidBST_DC(TreeNode root) {
        if (root == null) {
            return new ResultType(true, null, null);
        }

        ResultType left = checkValidBST_DC(root.left);
        ResultType right = checkValidBST_DC(root.right);
        if (left.isBST && right.isBST) {
            if (left.isNull() && !right.isNull()) {
                if (root.val < right.min.val) {
                    return new ResultType(true, root, right.max);
                } else {
                    return new ResultType(false, null, null);
                }
            } else if (!left.isNull() && right.isNull()) {
                if (left.max.val < root.val) {
                    return new ResultType(true, left.min, root);
                } else {
                    return new ResultType(false, null, null);
                }
            } else if (left.isNull() && right.isNull()) {
                return new ResultType(true, root, root);
            } else {
                if (left.max.val < root.val && root.val < right.min.val){
                    return new ResultType(true, left.min, right.max);
                } else {
                    return new ResultType(false, null, null);
                }
            }
        } else {
            return new ResultType(false, null, null);
        }
    }
}
