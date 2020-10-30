package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-22
 * https://leetcode-cn.com/problems/binary-tree-cameras/
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 */

public class MinCameraCover {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 0;
    }
}
