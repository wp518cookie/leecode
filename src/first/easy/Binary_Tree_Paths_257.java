package first.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-11-25
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */

public class Binary_Tree_Paths_257 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }
        List<String> path = new ArrayList();
        recursion(root, path, result);
        return result;
    }

    private void recursion(TreeNode root, List<String> path, List<String> result) {
        path.add(root.val + "");
        if (root.left == null && root.right == null) {
            addToResult(path, result);
        } else if (root.left == null || root.right == null) {
            recursion(root.left == null ? root.right : root.left, path, result);
        } else {
            recursion(root.left, path, result);
            recursion(root.right, path, result);
        }
        path.remove(path.size() - 1);
    }

    private void addToResult(List<String> path, List<String> result) {
        if (path.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i != path.size() - 1) {
                sb.append("->");
            }
        }
        result.add(sb.toString());
    }
}
