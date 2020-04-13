package likou.first_try.top;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-04-11
 *
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *  https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * 示例：
 *
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 *
 */

public class MaxLevelSum_1161 {
    public int maxLevelSum(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        int level = -1;
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            currentLevel += 1;
            int size = queue.size();
            int count = 0;
            while (size-- > 0) {
                TreeNode t = queue.poll();
                count += t.val;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            if (max < count) {
                level = currentLevel;
                max = count;
            }
        }
        return level;
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
