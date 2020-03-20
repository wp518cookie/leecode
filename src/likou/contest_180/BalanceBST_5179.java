package likou.contest_180;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-03-15
 * https://leetcode-cn.com/contest/weekly-contest-180/problems/balance-a-binary-search-tree/
 */

public class BalanceBST_5179 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(14);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(16);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(13);
        t1.left = t2;
        t2.left = t4;
        t2.right = t5;
        t1.right = t3;

        TreeNode result = new BalanceBST_5179().balanceBST(t1);
        System.out.println(123);
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList();
        inOrder(root, list);
        int mid = list.size() >> 1;
        TreeNode newRoot = new TreeNode(list.get(mid));
        newRoot.left = generateNewTree(list, 0, mid - 1);
        newRoot.right = generateNewTree(list, mid + 1, list.size() - 1);
        return newRoot;
    }

    public TreeNode generateNewTree(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(list.get(start));
        }
        int mid = start + ((end - start) >> 1);
        TreeNode t = new TreeNode(list.get(mid));
        t.left = generateNewTree(list, start, mid - 1);
        t.right = generateNewTree(list, mid + 1, end);
        return t;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
