package first.easy;

/**
 * @author wuping
 * @date 2019-10-31
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * <p>
 * Example:
 * Given a binary first.tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

public class Diameter_of_Binary_Tree_543 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l2.right = l5;
        System.out.println(new Diameter_of_Binary_Tree_543().diameterOfBinaryTree(l1));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.max(diameterOfBinaryTreeInternal(root.left) + diameterOfBinaryTreeInternal(root.right), diameterOfBinaryTree(root.left)), diameterOfBinaryTree(root.right));
    }

    public int diameterOfBinaryTreeInternal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(diameterOfBinaryTreeInternal(root.left), diameterOfBinaryTreeInternal(root.right));
    }
}
