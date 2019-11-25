package first.tree;

/**
 * @author wuping
 * @date 2019-08-01
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */

public class Trim_BST_669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = bstBiggerThan(root.left, L);
            root.right = bstSmallerThan(root.right, R);
            return root;
        }
    }

    public TreeNode bstBiggerThan(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val >= val) {
            node.left = bstBiggerThan(node.left, val);
            return node;
        } else {
            return bstBiggerThan(node.right, val);
        }
    }

    public TreeNode bstSmallerThan(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val <= val) {
            node.right = bstSmallerThan(node.right, val);
            return node;
        } else {
            return bstSmallerThan(node.left, val);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
