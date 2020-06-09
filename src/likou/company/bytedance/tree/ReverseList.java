package likou.company.bytedance.tree;

/**
 * @author wuping
 * @date 2020-06-05
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1038/
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */

public class ReverseList {
    private ListNode result;

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode head) {
        recursion(head);
        return result;
    }

    public ListNode recursion(ListNode head) {
        if (head.next == null) {
            result = head;
            return head;
        }
        ListNode t = recursion(head.next);
        head.next = null;
        t.next = head;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
