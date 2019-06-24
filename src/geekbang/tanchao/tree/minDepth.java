package geekbang.tanchao.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-06-10
 */

public class minDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        int newSize;
        int minDepth = 1;
        do {
            newSize = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                if (t.left == null && t.right == null) {
                    return minDepth;
                }
                if (t.left != null) {
                    queue.add(t.left);
                    newSize++;
                }
                if (t.right != null) {
                    queue.add(t.right);
                    newSize++;
                }
            }
            minDepth++;
            size = newSize;
        } while (size > 0);
        return minDepth;
    }

    public static void main(String[] args) {

    }
}
