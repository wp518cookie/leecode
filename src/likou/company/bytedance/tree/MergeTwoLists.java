package likou.company.bytedance.tree;

/**
 * @author wuping
 * @date 2020-06-05
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1048/
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }
        current.next = null;
        return dummy.next;
    }

    public class ListNode {
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
}
