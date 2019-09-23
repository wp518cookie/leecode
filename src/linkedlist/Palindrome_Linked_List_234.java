package linkedlist;

/**
 * @author wuping
 * @date 2019-09-23
 * https://leetcode.com/problems/palindrome-linked-list/
 * Input: 1->2
 * Output: false
 * Input: 1->2->2->1
 * Output: true
 */

public class Palindrome_Linked_List_234 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Palindrome_Linked_List_234 o = new Palindrome_Linked_List_234();
        System.out.println(o.isPalindrome(l1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy.next.next;
        ListNode slow = dummy.next;
        ListNode pre = dummy;
        ListNode next;
        while (true) {
            if (fast.next == null) {
                fast = slow.next;
                slow.next = pre;
                break;
            } else if (fast.next.next == null) {
                fast = slow.next.next;
                slow.next = pre;
                break;
            } else {
                next = slow.next;
                slow.next = pre;
                pre = slow;
                slow = next;
                fast = fast.next.next;
            }
        }
        while (slow != null && fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
