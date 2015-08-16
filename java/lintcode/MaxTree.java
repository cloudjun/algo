package lintcode;

import lintcode.ninechapter3.TreeNode;

import java.util.Stack;

/**
 * Created by jun on 8/3/2015.
 */
public class MaxTree {
    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            TreeNode curt = new TreeNode(A[i]);
            while (!stack.isEmpty() && curt.val > stack.peek().val) {
                curt.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curt;
            }
            stack.push(curt);
        }

        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;
    }
}
