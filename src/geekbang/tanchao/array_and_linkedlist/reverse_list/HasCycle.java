package geekbang.tanchao.array_and_linkedlist.reverse_list;

/**
 * @author wuping
 * @date 2019-05-10
 * 给定一个链表，判断链表中是否有环。O(1)空间复杂度
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast.next == null) {
                return false;
            }
            if (fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        return true;
    }
}
