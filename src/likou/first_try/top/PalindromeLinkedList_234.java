package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-20
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        int time = count / 2;
        while (time-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (count % 2 != 0) {
            cur = cur.next;
        }
        ListNode h1 = pre;
        ListNode h2 = cur;
        while (h1 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
