package first.contest.contest_169;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2019-12-29
 */

public class All_Elements_in_Two_Binary_Search_Trees_5296 {
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList();
        if (root1 == null && root2 == null) {
            return result;
        } else if (root1 == null || root2 == null) {
            return root1 == null ? recursion(root2) : recursion(root1);
        }
        List<Integer> l1 = recursion(root1);
        List<Integer> l2 = recursion(root2);
        int c1 = 0;
        int c2 = 0;
        while (c1 < l1.size() && c2 < l2.size()) {
            int t1 = l1.get(c1);
            int t2 = l2.get(c2);
            if (t1 < t2) {
                result.add(t1);
                c1++;
            } else {
                result.add(t2);
                c2++;
            }
        }
        while (c1 < l1.size()) {
            result.add(l1.get(c1++));
        }
        while (c2 < l2.size()) {
            result.add(l2.get(c2++));
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

    private List<Integer> recursion(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}
