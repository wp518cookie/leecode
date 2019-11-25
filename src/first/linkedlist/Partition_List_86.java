package first.linkedlist;

/**
 * @author wuping
 * @date 2019-10-16
 * https://leetcode.com/problems/partition-list/
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 */

public class Partition_List_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = head;
        int count = 0;
        int flag = -1;
        boolean check = false;
        while ( end != null) {
            count++;
            if (flag < 0) {
                if (end.val >= x) {
                    flag = count;
                }
            } else {
                if (end.val < x) {
                    check = true;
                }
            }
            if (end.next != null) {
                end = end.next;
            } else {
                break;
            }
        }
        if (!check) {
            return head;
        }
        ListNode cursor = head;
        ListNode prev = dummy;
        while (count-- > 0) {
            if (cursor.val >= x) {
                prev.next = cursor.next;
                end.next = cursor;
                end = cursor;
                end.next = null;
                cursor = prev.next;
            } else {
                prev = cursor;
                cursor = cursor.next;
            }
        }
        return dummy.next;
    }
}
