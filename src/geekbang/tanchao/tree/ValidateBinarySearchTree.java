package geekbang.tanchao.tree;

/**
 * @author wuping
 * @date 2019-05-22
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!processorJudge(root) || !successorJudge(root)) {
            return false;
        }
        return judge(root);
    }

    public boolean judge(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean processorJudge(TreeNode root) {
        if (root.left == null) {
            return true;
        }
        TreeNode t = root.left;
        while (t.right != null) {
            t = t.right;
        }
        return t.val < root.val;
    }

    public boolean successorJudge(TreeNode root) {
        if (root.right == null) {
            return true;
        }
        TreeNode t = root.right;
        while (t.left != null) {
            t = t.left;
        }
        return t.val > root.val;
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
