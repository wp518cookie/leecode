package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-03
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            pre.next = l2;
            pre = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
