package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-28
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * 0
 * [1]
 * []
 * 1
 * 0
 */

public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode t1 = headA;
        ListNode t2 = headB;
        boolean t1Flag = true;
        boolean t2Flag = true;
        while (true) {
            if (t1 == null) {
                if (t1Flag) {
                    t1 = headB;
                    t1Flag = false;
                } else {
                    return null;
                }
            }
            if (t2 == null) {
                if (t2Flag) {
                    t2 = headA;
                    t2Flag = false;
                } else {
                    return null;
                }
            }
            if (t1 == t2) {
                return t1;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
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
