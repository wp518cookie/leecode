package geekbang.tanchao.array_and_linkedlist.reverse_list;

/**
 * @author wuping
 * @date 2019-05-11
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode h = reverseKGroup(l1, 2);
        ListNode.print(h);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode first = cur;
        ListNode next = null;
        while (true) {
            int t = k;
            if (!check(cur, t)) {
                return dummy.next;
            }
            t--;
            first = cur;
            cur = cur.next;
            while (t-- > 0) {
                next = cur.next;
                first.next = next;
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            pre = first;
        }
    }

    private static boolean check(ListNode n, int k) {
        while (k-- > 0) {
            if (n == null) {
                return false;
            }
            n = n.next;
        }
        return true;
    }
}
