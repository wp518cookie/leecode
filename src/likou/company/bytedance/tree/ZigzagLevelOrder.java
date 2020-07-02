package likou.company.bytedance.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-07-02
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1027/
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> list = new LinkedList();
        boolean ifLeftToRight = true;
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            List<Integer> tempList = new ArrayList();
            if (ifLeftToRight) {
                while (size-- > 0) {
                    TreeNode t = list.removeFirst();
                    tempList.add(t.val);
                    if (t.left != null) {
                        list.addLast(t.left);
                    }
                    if (t.right != null) {
                        list.addLast(t.right);
                    }
                }
                result.add(tempList);
                ifLeftToRight = !ifLeftToRight;
            } else {
                while (size-- > 0) {
                    TreeNode t = list.removeLast();
                    tempList.add(t.val);
                    if (t.right != null) {
                        list.addFirst(t.right);
                    }
                    if (t.left != null) {
                        list.addFirst(t.left);
                    }
                }
                result.add(tempList);
                ifLeftToRight = !ifLeftToRight;
            }
        }
        return result;
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
