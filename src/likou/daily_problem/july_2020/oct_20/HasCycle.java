package likou.daily_problem.july_2020.oct_20;

/**
 * @author wuping
 * @date 2020-10-09
 */

public class HasCycle {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
