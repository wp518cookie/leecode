package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-13
 * https://leetcode-cn.com/problems/sort-list/
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 */

public class SortList_148 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l3;
        l3.next = l4;
        l4.next = l2;
        ListNode result = new SortList_148().sortList(l1);
        System.out.println(123);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = new ListNode(-1);
        ListNode mark = head;
        ListNode second = new ListNode(-1);
        ListNode fc = first;
        ListNode sc = second;

        ListNode current = head.next;

        while (current != null) {
            if (current.val < mark.val) {
                fc.next = current;
                fc = fc.next;
                current = current.next;
            } else {
                sc.next = current;
                sc = sc.next;
                current = current.next;
            }
        }
        fc.next = head;
        // todo
        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
