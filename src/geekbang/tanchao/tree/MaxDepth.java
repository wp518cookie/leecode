package geekbang.tanchao.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-06-10
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
 */

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int size = 1;
        int newSize;
        do {
            newSize = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    queue.add(t.left);
                    newSize++;
                }
                if (t.right != null) {
                    queue.add(t.right);
                    newSize++;
                }
            }
            if (newSize > 0) {
                depth++;
            }
            size = newSize;
        } while (size > 0);
        return depth;
    }

    public int maxDepthRecursion(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepthRecursion(node.left) + 1;
        int right = maxDepthRecursion(node.right) + 1;
        return left > right ? left : right;
    }
}
