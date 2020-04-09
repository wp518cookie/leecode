package likou.first_try.top;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-08
 * <p>
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 1
 */

public class KthSmallest_230 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t3.left = t1;
        t3.right = t4;
        t1.right = t2;
        System.out.println(new KthSmallest_230().kthSmallest(t3, 1));
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            while (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                list.add(t.val);
                if (t.right != null) {
                    current = t.right;
                    break;
                }
            }
        }
        return list.get(k - 1);
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
