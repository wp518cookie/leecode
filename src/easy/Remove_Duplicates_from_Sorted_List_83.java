package easy;

/**
 * Created by Administrator on 2017/12/20.
 */
public class Remove_Duplicates_from_Sorted_List_83 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode before;
        if (head != null) {
            before = head;
        } else {
            return null;
        }
        ListNode tmp = head.next;
        while (tmp != null) {
            if (before.val == tmp.val) {
                ListNode delItem = tmp;
                tmp = tmp.next;
                delItem.next = null;
            } else {
                before.next = tmp;
                before = tmp;
                tmp = tmp.next;
            }
        }
        before.next = null;
        return head;
    }
}
