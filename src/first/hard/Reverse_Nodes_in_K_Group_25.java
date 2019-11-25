package first.hard;

/**
 * Created by Administrator on 2018/3/5.
 */
public class Reverse_Nodes_in_K_Group_25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        reverseKGroup(l1, 3);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
