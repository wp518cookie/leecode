package easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Merge_Two_Sorted_Lists_21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead;
        ListNode temp;
        if (l1.val >= l2.val) {
            newHead = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            newHead = new ListNode(l1.val);
            l1 = l1.next;
        }
        temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
        }
        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return newHead;
    }
}
