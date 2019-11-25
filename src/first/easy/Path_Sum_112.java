package first.easy;

/**
 * Created by Administrator on 2018/1/30.
 */
public class Path_Sum_112 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            return (root.left == null ? false : hasPathSum(root.left, sum - root.val)) ||
                    (root.right == null ? false : hasPathSum(root.right, sum - root.val));
        }
    }

    public static void main(String[] args) {

    }
}
