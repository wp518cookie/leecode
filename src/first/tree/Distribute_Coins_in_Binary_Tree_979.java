package first.tree;

/**
 * @author wuping
 * @date 2019-11-26
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.
 *
 * In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)
 *
 * Return the number of moves required to make every node have exactly one coin.
 *
 * Input: [3,0,0]
 * Output: 2
 * Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 */

public class Distribute_Coins_in_Binary_Tree_979 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);

    }

    private int res = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        travel(root);
        return res;
    }

    private int travel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = travel(node.left);
        int right = travel(node.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right - 1 + node.val;
    }
}
