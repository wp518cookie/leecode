package first.easy;

/**
 * Created by Administrator on 2017/12/13.
 * https://leetcode.com/problems/path-sum-iii/
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */

public class Path_Sum_III_437 {
    private static int count = 0;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        TreeNode l1 = new TreeNode(10);
//        TreeNode l2 = new TreeNode(5);
//        TreeNode l3 = new TreeNode(-3);
//        TreeNode l4 = new TreeNode(3);
//        TreeNode l5 = new TreeNode(2);
//        TreeNode l6 = new TreeNode(11);
//        TreeNode l7 = new TreeNode(3);
//        TreeNode l8 = new TreeNode(-2);
//        TreeNode l9 = new TreeNode(1);
//        l1.left = l2;
//        l1.right = l3;
//        l2.left = l4;
//        l2.right = l5;
//        l3.right = l6;
//        l4.left = l7;
//        l4.right = l8;
//        l5.right = l9;
//        System.out.println(pathSum(l1, 8));
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        l1.right = l2;
        l2.right = l3;
        l3.right = l4;
        l4.right = l5;
        System.out.println(pathSum(l1, 3));
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            count++;
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        pathSumInternal(root.left, sum - root.val);
        pathSumInternal(root.right, sum - root.val);
        return count;
    }

    public static void pathSumInternal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum) {
            count++;
        }
        pathSumInternal(root.left, sum - root.val);
        pathSumInternal(root.right, sum - root.val);
    }
}
