package likou.first_try.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2020-03-28
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *
 * todo 效率太低
 *
 */

public class Symmetric_tree_101 {
    /**
     * 执行用时 :197 ms, 在所有 Java 提交中击败了10.40%的用户
     * 内存消耗 :244.1 MB, 在所有 Java 提交中击败了5.10%的用户
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean nullFlag = true;
            List<Integer> temp = new ArrayList();
            while (size-- > 0) {
                TreeNode t = queue.poll();
                temp.add(t == null ? null : t.val);
                if (t == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    if (t.left != null || t.right != null) {
                        nullFlag = false;
                    }
                    queue.offer(t.left);
                    queue.offer(t.right);
                }
            }
            if (!isSymmetric(temp)) {
                return false;
            }
            if (nullFlag) {
                return true;
            }
        }
        return true;
    }

    public boolean isSymmetric(List<Integer> list) {
        int length = list.size();
        int count = length / 2;
        for (int i = 0; i < count; i++) {
            Integer t1 = list.get(i);
            Integer t2 = list.get(length - 1 -  i);
            if (t1 == null) {
                if (t2 == null) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!t1.equals(t2)) {
                    return false;
                }
            }
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
