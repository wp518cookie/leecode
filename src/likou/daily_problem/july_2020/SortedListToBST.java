package likou.daily_problem.july_2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-18
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */

public class SortedListToBST {
    // 常数空间复杂度解法
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        ListNode cur = slow.next;
        slow.next = null;
        TreeNode root = new TreeNode(cur.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(next);
        return root;
    }

//    public TreeNode sortedListToBST(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        if (head.next == null) {
//            return new TreeNode(head.val);
//        }
//        List<Integer> list = new ArrayList();
//        ListNode cur = head;
//        while (cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        return recursion(list, 0, list.size() - 1);
//    }
//
//    private TreeNode recursion(List<Integer> list, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        int mid = start + (end - start) / 2;
//        TreeNode root = new TreeNode(list.get(mid));
//        if (start == end) {
//            return root;
//        }
//        root.left = recursion(list, start, mid - 1);
//        root.right = recursion(list, mid + 1, end);
//        return root;
//    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
}
