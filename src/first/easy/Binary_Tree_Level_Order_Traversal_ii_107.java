package first.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-12-31
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */

public class Binary_Tree_Level_Order_Traversal_ii_107 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (size > 0) {
            int newSize = 0;
            List<Integer> temp = new ArrayList();
            while (size-- > 0) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null) {
                    newSize++;
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    newSize++;
                    queue.offer(t.right);
                }
            }
            size = newSize;
            result.addFirst(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(0, 1);
        list.add(1, 2);
        System.out.println(list.size());
    }
}
