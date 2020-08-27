package likou.daily_problem.july_2020;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-08-21
 */

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                TreeNode t = list.removeFirst();
                if (t.left == null && t.right == null) {
                    return result;
                }
                if (t.left != null) {
                    list.add(t.left);
                }
                if (t.right != null) {
                    list.add(t.right);
                }
            }
            result++;
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
