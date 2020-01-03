package first.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2020-01-03
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */

public class Binary_Tree_Right_Side_View_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int size = 1;
        while (size > 0) {
            int newSize = 0;
            int lastVal = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                lastVal = t.val;
                if (t.left != null) {
                    queue.offer(t.left);
                    newSize++;
                }
                if (t.right != null) {
                    queue.offer(t.right);
                    newSize++;
                }
            }
            result.add(lastVal);
            size = newSize;
        }
        return result;
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
