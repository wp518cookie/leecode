package first.linkedlist;

/**
 * @author wuping
 * @date 2019-09-25
 * https://leetcode.com/problems/split-linked-list-in-parts/
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 */

public class Split_Linked_List_in_Parts_725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        ListNode[] result = new ListNode[k];
        int count = 0;
        ListNode cursor = root;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        if (count <= k) {
            processLowerOrEqual(root, count, result);
        } else {
            int times = count / k;
            int extra = count % k;
            processGreater(root, times, extra, k, result);
        }
        return result;
    }

    private void processLowerOrEqual(ListNode cursor, int count, ListNode[] result) {
        ListNode next;
        int i = 0;
        while (i < count) {
            next = cursor.next;
            result[i] = cursor;
            cursor.next = null;
            cursor = next;
            i++;
        }
    }

    private void processGreater(ListNode cursor, int times, int extra, int k, ListNode[] result) {
        ListNode next;
        int i = 0;
        while (i < k) {
            int j = 1;
            result[i] = cursor;
            while (j < times) {
                cursor = cursor.next;
                j++;
            }
            if (i < extra) {
                cursor = cursor.next;
            }
            next = cursor.next;
            cursor.next = null;
            cursor = next;
            i++;
        }
    }
}
