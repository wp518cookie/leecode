package likou.daily_problem.july_2020.sep_20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-09-25
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

public class BuildTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mark = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            mark.put(inorder[i], i);
        }
        return recursion(mark, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode recursion(Map<Integer, Integer> mark, int[] postorder, int inStart, int inEnd, int pStart, int pEnd) {
        if (pStart > pEnd) {
            return null;
        }
        if (pStart == pEnd) {
            return new TreeNode(postorder[pStart]);
        }
        int val = postorder[pEnd];
        int idx = mark.get(val);
        int count = idx - inStart;
        TreeNode root = new TreeNode(val);
        root.left = recursion(mark, postorder, inStart, idx - 1, pStart, pStart + count - 1);
        root.right = recursion(mark, postorder, idx + 1, inEnd, pStart + count, pEnd - 1);
        return root;
    }
}
