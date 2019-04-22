package geekbang.tanchao.array_and_linkedlist.reverse_list;

/**
 * @author wuping
 * @date 2019-04-22
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */

public class ReverseList {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        ListNode result = reverseList(t1);
        ListNode.print(result);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 递归，比较难理解
     * step1 : t1 -> t2 -> t3 -> t4
     * step2 : t1 -> t2 -> t3   t4 -> t3
     * step3 : t1 -> t2    t4 -> t3 -> t2
     */
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
