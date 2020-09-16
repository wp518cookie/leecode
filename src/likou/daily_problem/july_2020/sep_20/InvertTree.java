package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-16
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(right);
        return root;
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
