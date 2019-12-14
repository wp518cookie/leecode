package first.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-12-14
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 */

public class Find_Largest_Value_in_Each_Tree_Row_515 {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int newSize = 0;
            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                    newSize++;
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    newSize++;
                }
            }
            size = newSize;
            result.add(max);
        }
        return result;
    }
}
