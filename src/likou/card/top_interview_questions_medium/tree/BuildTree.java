package likou.card.top_interview_questions_medium.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvix0d/
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */

public class BuildTree {
    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode t = new BuildTree().buildTree(preOrder, inOrder);
        System.out.println(t.val);
    }

    /**
     * 执行用时：
     * 3 ms, 在所有 Java 提交中击败了76.20%的用户
     * 内存消耗：
     * 40.6 MB, 在所有 Java 提交中击败了13.63%的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderMark = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMark.put(inorder[i], i);
        }
        int start = 0;
        int end = preorder.length - 1;
        int preStart = 0;
        int preEnd = preorder.length - 1;
        TreeNode root = new TreeNode(preorder[0]);
        int idx = inOrderMark.get(preorder[0]);
        root.left = recursion(preorder, preStart + 1,  preStart + 1 + idx - 1 - start, inorder, inOrderMark, start, idx - 1);
        root.right = recursion(preorder, preStart + 1 + idx - 1 - start + 1, preEnd, inorder, inOrderMark, idx + 1, end);
        return root;
    }

    private TreeNode recursion(int[] preOrder, int preStart, int preEnd,
                               int[] inOrder, Map<Integer, Integer> inOrderMark,
                               int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(inOrder[start]);
        }
        TreeNode t = new TreeNode(preOrder[preStart]);
        int idx = inOrderMark.get(preOrder[preStart]);
        int count = idx - start;
        t.left = recursion(preOrder, preStart + 1, preStart + 1 + count - 1, inOrder, inOrderMark, start, idx - 1);
        t.right = recursion(preOrder, preStart + 1 + count, preEnd,  inOrder, inOrderMark, idx + 1, end);
        return t;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
