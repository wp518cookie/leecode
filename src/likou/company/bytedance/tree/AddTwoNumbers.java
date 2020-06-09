package likou.company.bytedance.tree;

/**
 * @author wuping
 * @date 2020-06-05
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1022/
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            int t = flag ? 1 : 0;
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            if (t >= 10) {
                t = t % 10;
                flag = true;
            } else {
                flag = false;
            }
            current.next = new ListNode(t);
            current = current.next;
        }
        if (flag) {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
