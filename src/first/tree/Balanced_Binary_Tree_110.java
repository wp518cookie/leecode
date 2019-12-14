package first.tree;

/**
 * @author wuping
 * @date 2019-11-26
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as:
 * <p>
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 */

public class Balanced_Binary_Tree_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return flag;
    }

    public int getDepth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (!flag) {
            return 0;
        }
        int left = 1 + getDepth(n.left);
        int right = 1 + getDepth(n.right);
        if (left > right + 1 || right > left + 1) {
            flag = false;
        }
        return Math.max(left, right);
    }
}
