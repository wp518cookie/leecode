package likou.first_try.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-08
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 */

public class InorderTraversal_94 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t3.left = t1;
        t3.right = t4;
        t1.right = t2;
        List<Integer> result = new InorderTraversal_94().inorderTraversal(t3);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                result.add(t.val);
                if (t.right != null) {
                    current = t.right;
                    break;
                }
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
