package first.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2019-09-25
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * Input: [2,1,5]
 * Output: [5,5,0]
 * <p>
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 *
 */

public class Next_Greater_Node_In_Linked_List_1019 {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList();
        ListNode t = head;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }
        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return result;
    }
}
