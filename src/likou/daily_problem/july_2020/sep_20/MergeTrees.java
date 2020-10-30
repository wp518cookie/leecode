package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-23
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，
 * 两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 */

public class MergeTrees {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        } else {
            TreeNode t = new TreeNode(t1.val + t2.val);
            t.left = mergeTrees(t1.left, t2.left);
            t.right = mergeTrees(t1.right, t2.right);
            return t;
        }
    }
}
