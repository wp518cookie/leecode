package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2019-08-01
 * https://leetcode.com/problems/leaf-similar-trees/
 */

public class Leaf_Similar_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> result1 = getLeaf(root1);
        List<Integer> result2 = getLeaf(root2);
        if (result1.size() != result2.size()) {
            return false;
        }
        if (result1.size() == 0 && result2.size() == 0) {
            return true;
        }
        for (int i = 0; i < result1.size(); i++) {
            if (!result1.get(i).equals(result2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeaf(TreeNode node) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (node.left == null && node.right == null) {
                    result.add(node.val);
                }
                node = node.right;
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
