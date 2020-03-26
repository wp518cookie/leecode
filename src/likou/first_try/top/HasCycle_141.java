package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-26
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */

public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
    }

   private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
