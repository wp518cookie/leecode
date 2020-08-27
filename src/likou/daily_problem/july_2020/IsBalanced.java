package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-08-17
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */

public class IsBalanced {
    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left - right > 1 || right - left > 1) {
            return false;
        }
        return result;
    }

    public int getHeight(TreeNode node) {
        if (!result) {
            return -1;
        }
        if (node == null) {
            return 0;
        }
        int h1 = getHeight(node.left);
        int h2 = getHeight(node.right);
        if (!result) {
            return -1;
        }
        if (h1 - h2 > 1 || h2 - h1 > 1) {
            result = false;
            return -1;
        }
        return Math.max(h1, h2) + 1;
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
