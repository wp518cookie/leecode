package likou.company.bytedance.tree;

/**
 * @author wuping
 * @date 2020-06-05
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class SortList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        new SortList().sortList(l1);
    }

    // 官方解答1
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode fast = head.next, slow = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (left != null && right != null) {
//            if (left.val < right.val) {
//                cur.next = left;
//                left = left.next;
//            } else {
//                cur.next = right;
//                right = right.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = left == null ? right : left;
//        return dummy.next;
//    }

    // 官方1 自己实现 自上而下，相对简单
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode fast = head;
//        ListNode slow = head;
//        while (fast.next != null && fast.next.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode tmp = slow.next;
//        slow.next = null;
//        ListNode left = sortList(head);
//        ListNode right = sortList(tmp);
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while (left != null && right != null) {
//            if (left.val <= right.val) {
//                cur.next = left;
//                left = left.next;
//            } else {
//                cur.next = right;
//                right = right.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = left == null ? right : left;
//        return dummy.next;
//    }

    //官方2  自下而上
    public ListNode sortList(ListNode head) {
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
