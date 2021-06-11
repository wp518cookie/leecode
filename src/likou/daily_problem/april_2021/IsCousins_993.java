package likou.daily_problem.april_2021;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuping
 * @date 2021-05-17
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * 提示：
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */

public class IsCousins_993 {
    // 层序遍历， 时间复杂度O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xFlag = false;
        boolean yFlag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        if (node.right != null && node.right.val == y) {
                            return false;
                        }
                        xFlag = true;
                    } else if (node.left.val == y) {
                        if (node.right != null && node.right.val == x) {
                            return false;
                        }
                        yFlag = true;
                    }
                }
                if (xFlag && yFlag) {
                    return true;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        xFlag = true;
                    }
                    if (node.right.val == y) {
                        yFlag = true;
                    }
                }
            }
            if (xFlag && yFlag) {
                return true;
            }
            if (xFlag || yFlag) {
                return false;
            }
        }
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
