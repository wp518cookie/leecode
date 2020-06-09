//package likou.company.bytedance.tree;
//
///**
// * @author wuping
// * @date 2020-06-05
// * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
// *
// * 示例 1:
// *
// * 输入: 4->2->1->3
// * 输出: 1->2->3->4
// * 示例 2:
// *
// * 输入: -1->5->3->4->0
// * 输出: -1->0->3->4->5
// */
//
//public class SortList {
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode(4);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(1);
//        ListNode l4 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        new SortList().sortList(l1);
//    }
//
//    public ListNode sortList(ListNode head) {
//         return recursion(head);
//    }
//
//    public ListNode recursion(ListNode head) {
//        while (head == null || head.next == null) {
//            return head;
//        }
//        ListNode dummy1 = new ListNode(-1);
//        ListNode dummy2 = new ListNode(-1);
//        ListNode c1 = dummy1;
//        ListNode c2 = dummy2;
//        ListNode current = head.next;
//        while (current != null) {
//            if (current.val <= head.val) {
//                c1.next = current;
//                c1 = c1.next;
//            } else {
//                c2.next = current;
//                c2 = c2.next;
//            }
//            current = current.next;
//        }
//        c1.next = head;
//        c2.next = null;
//
//    }
//
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//}
