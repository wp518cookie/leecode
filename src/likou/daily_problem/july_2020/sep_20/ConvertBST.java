package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-21
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 给定一个二叉搜索树（Binary Search Tree），
 * 把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 */

public class ConvertBST {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(-2);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        TreeNode t = new ConvertBST().convertBST(t1);
        System.out.println(t.val);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        recursion(root, 0);
        return root;
    }

    public int recursion(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        int right = recursion(node.right, val);
        node.val = right == 0 ? node.val + val : node.val + right;
        int left = recursion(node.left, node.val);
        return left == 0 ? node.val : left;
    }
}
