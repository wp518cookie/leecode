package first.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-08-01
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */

public class Is_Unival_Tree_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int target = root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int newCount = 0;
            while (count-- > 0) {
                TreeNode t = queue.poll();
                if (t.val != target) {
                    return false;
                }
                if (t.left != null) {
                    queue.offer(t.left);
                    newCount++;
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    newCount++;
                }
            }
            count = newCount;
        }
        return true;
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
