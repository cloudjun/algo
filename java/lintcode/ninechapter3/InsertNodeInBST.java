package lintcode.ninechapter3;

import java.util.AbstractCollection;

/**
 * Created by jun on 7/20/2015.
 */
public class InsertNodeInBST {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode_recursive(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }

        if (root.val >= node.val) {
            if (root.left == null) {
                root.left = node;
                return root;
            } else {
                insertNode_recursive(root.left, node);
                return root;
            }
        } else {
            if (root.right == null) {
                root.right = node;
                return root;
            } else {
                insertNode_recursive(root.right, node);
                return root;
            }
        }
    }

    public TreeNode insertNode_DC(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }

        if (root.val >= node.val) {
            root.left = insertNode_DC(root.left, node);
        } else {
            root.right = insertNode_DC(root.right, node);
        }
        return root;
    }

    public TreeNode insertNode_non_recursive(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        if (node == null) {
            return root;
        }

        TreeNode temp = root;
        while (temp != null) {
            if (temp.val >= node.val) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
        return root;
    }
}
