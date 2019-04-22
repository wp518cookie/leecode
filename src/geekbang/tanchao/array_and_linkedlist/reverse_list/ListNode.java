package geekbang.tanchao.array_and_linkedlist.reverse_list;

/**
 * @author wuping
 * @date 2019-04-22
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
