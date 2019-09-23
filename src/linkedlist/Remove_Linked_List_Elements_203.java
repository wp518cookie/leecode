package linkedlist;

/**
 * @author wuping
 * @date 2019-09-23
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

public class Remove_Linked_List_Elements_203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode next;
        while (cur != null) {
            if (cur.val == val) {
                next = cur.next;
                cur.next = null;
                pre.next = next;
                cur = next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
