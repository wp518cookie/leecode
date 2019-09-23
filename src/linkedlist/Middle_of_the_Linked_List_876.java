package linkedlist;

/**
 * @author wuping
 * @date 2019-09-23
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 */

public class Middle_of_the_Linked_List_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return slow.next;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }
}
