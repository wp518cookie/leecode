package first.contest.contest_167;

/**
 * @author wuping
 * @date 2019-12-17
 * https://leetcode.com/contest/weekly-contest-167/problems/convert-binary-number-in-a-linked-list-to-integer/
 * <p>
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 */

public class Convert_Binary_Number_in_a_Linked_List_to_Integer_1290 {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
