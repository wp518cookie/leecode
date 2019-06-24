package geekbang.tanchao.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-06-10
 * https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
 * 二叉树层次遍历
 */

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int size = 1;
        int newSize;
        do {
            List<Integer> meta = new ArrayList();
            newSize = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                meta.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                    newSize++;
                }
                if (t.right != null) {
                    queue.add(t.right);
                    newSize++;
                }
            }
            result.add(meta);
            size = newSize;
        } while (size > 0);
        return result;
    }

    public static void main(String[] args) {

    }
}
