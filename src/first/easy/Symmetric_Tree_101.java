package first.easy;

/**
 * @author wuping
 * @date 2019-10-29
 * https://leetcode.com/problems/symmetric-tree/submissions/
 */

public class Symmetric_Tree_101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricRecursion(root.left, root.right);
    }

    public boolean isSymmetricRecursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricRecursion(left.left, right.right) && isSymmetricRecursion(left.right, right.left);
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
