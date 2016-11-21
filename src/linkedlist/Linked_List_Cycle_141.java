package linkedlist;

import java.util.List;

/**
 * Created by ping.wu on 2016/11/17.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Linked_List_Cycle_141 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;
        System.out.println(hasCycle(listNode1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else {
            while (head.next != null) {
                if (head == head.next) {
                    return true;
                }
                head.next = head.next.next;
                head = head.next;
                if (head == null) {
                    return false;
                }
            }
        }
        return false;
    }
}
