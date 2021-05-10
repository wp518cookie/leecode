package likou.daily_problem.april_2021;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2021-05-10
 *
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * 提示：
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 */

public class LeafSimilar_872 {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        TreeNode l7 = new TreeNode(7);
        TreeNode l8 = new TreeNode(8);
        TreeNode l9 = new TreeNode(9);

        l3.left = l5;
        l3.right = l1;
        l5.left = l6;
        l5.right = l2;
        l1.left = l9;
        l1.right = l8;
        l2.left = l7;
        l2.right = l4;

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        TreeNode r9 = new TreeNode(9);

        r3.left = r5;
        r3.right = r1;
        r5.left = r6;
        r5.right = r2;
        r1.left = r9;
        r1.right = r8;
        r2.left = r7;
        r2.right = r4;

        new LeafSimilar_872().leafSimilar(l3, r3);
    }

    private static class TreeNode {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        recursion(root1, r1);
        List<Integer> r2 = new ArrayList<>();
        recursion(root2, r2);

        if (r1.size() != r2.size()) {
            return false;
        }
        for (int i = 0; i < r1.size(); i++) {
            if (!r1.get(i).equals(r2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void recursion(TreeNode t, List<Integer> result) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            result.add(t.val);
            return;
        }
        recursion(t.left, result);
        recursion(t.right, result);
    }
}

