package linkedlist;

/**
 * @author wuping
 * @date 2019-10-16
 */

public class Reverse_Linked_List_II_92 {
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
        new Reverse_Linked_List_II_92().reverseBetween(l1, 2, 3);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cursor = head;
        int count = 0;
        ListNode start = dummy;
        if (m == 1) {
            start = dummy;
        }
        while (cursor != null) {
            count++;
            if (count <= m) {
                if (count == m - 1) {
                    start = cursor;
                }
                pre = cursor;
                cursor = cursor.next;
            } else if (count <= n) {
                pre.next = cursor.next;
                cursor.next = start.next;
                start.next = cursor;
                cursor = pre.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}
