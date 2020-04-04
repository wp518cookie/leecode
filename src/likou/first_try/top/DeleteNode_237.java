package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-04
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 */

public class DeleteNode_237 {
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            node = null;
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        next.next = null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
