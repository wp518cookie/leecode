package first.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-11-15
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */

public class Maximum_Level_Sum_of_a_Binary_Tree_1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val;
        int resultLevel = 1;
        int currentLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()) {
            int newSize = 0;
            int newVal = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                if (t.left != null) {
                    newVal += t.left.val;
                    queue.offer(t.left);
                    newSize++;
                }
                if (t.right != null) {
                    newVal += t.right.val;
                    queue.offer(t.right);
                    newSize++;
                }
            }
            if (newSize == 0) {
                break;
            } else {
                currentLevel++;
                size = newSize;
                if (newVal > result) {
                    result=newVal;
                    resultLevel = currentLevel;
                }
            }
        }
        return resultLevel;
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
