package first.easy;

/**
 * Created by ping.wu on 2016/11/17.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Sum_of_Left_Leaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
