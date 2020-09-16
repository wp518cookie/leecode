package likou.daily_problem.july_2020.sep_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-09-14
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
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                result.add(t.val);
                if (t.right != null) {
                    root = t.right;
                    break;
                }
            }
        }
        return result;
    }
}
