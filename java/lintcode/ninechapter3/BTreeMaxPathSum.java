package lintcode.ninechapter3;

/**
 * Created by jun on 8/16/2015.
 */
public class BTreeMaxPathSum {
    private int _maxLeftSingle = Integer.MIN_VALUE;
    private int _maxRightSingle = Integer.MIN_VALUE;
    private int _maxAll = Integer.MIN_VALUE;

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    /*
    **  My solution, some cases errored out, not sure why
    *
    public int maxPathSum(TreeNode root) {
        getSinglePathMax(root);
        return Math.max(_maxLeftSingle, Math.max(_maxRightSingle, _maxAll));
    }

    public int getSinglePathMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = getSinglePathMax(root.left);
        int right = getSinglePathMax(root.right);

        if (root.val >= 0) {
            _maxLeftSingle = Math.max(_maxLeftSingle, left <= 0 ? root.val : left + root.val);
            _maxRightSingle = Math.max(_maxRightSingle, right <= 0 ? root.val : right + root.val);
            _maxAll = Math.max(_maxAll, (left <= 0 ? 0 : left)
                                        + (right <= 0 ? 0 : right)
                                        + root.val);
        } else {
            _maxLeftSingle = Math.max(_maxLeftSingle, left <= 0 ? root.val : _maxLeftSingle);
            _maxRightSingle = Math.max(_maxRightSingle, right <= 0 ? root.val : _maxRightSingle);
            _maxAll = Math.max(_maxAll, (left <= 0 ? 0 : left)
                    + (right <= 0 ? 0 : right)
                    + root.val);
        }

        int max = Math.max(left, right);
        return max == Integer.MIN_VALUE ? root.val : max + root.val;
    }
    */

    private class ResultType {
        // singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        // Conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
}
