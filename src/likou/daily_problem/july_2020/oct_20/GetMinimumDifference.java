package likou.daily_problem.july_2020.oct_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-10-12
 */

public class GetMinimumDifference {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t4.left = t2;
        t4.right = t6;
        t2.left = t1;
        t2.right = t3;
        t6.left = t5;
        t6.right = t7;
        new GetMinimumDifference().getMinimumDifference(t4);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i) - result.get(i - 1));
        }
        return min;
    }

    private void recursion(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        recursion(node.left, list);
        list.add(node.val);
        recursion(node.right, list);
    }
}
