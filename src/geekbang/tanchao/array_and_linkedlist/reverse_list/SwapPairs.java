package geekbang.tanchao.array_and_linkedlist.reverse_list;

/**
 * @author wuping
 * @date 2019-04-22
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode next;
        while (cur != null && cur.next != null) {
            next = cur.next.next;
            cur.next.next = cur;
            prev.next = cur.next;
            cur.next = next;
            prev = cur;
            cur = next;
        }
        return dummy.next;
    }
}
