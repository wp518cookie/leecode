package first.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-12-12
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 */

public class Find_Bottom_Left_Tree_Value_513 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t3.right = t6;
        t5.left = t7;
        System.out.println(new Find_Bottom_Left_Tree_Value_513().findBottomLeftValue(t1));
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        int result = root.val;
        while (!queue.isEmpty()) {
            boolean first = true;
            int newSize = 0;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (first) {
                        result = node.left.val;
                        first = false;
                    }
                    queue.offer(node.left);
                    newSize++;
                }
                if (node.right != null) {
                    if (first) {
                        result = node.right.val;
                        first = false;
                    }
                    queue.offer(node.right);
                    newSize++;
                }
            }
            size = newSize;
        }
        return result;
    }
}
