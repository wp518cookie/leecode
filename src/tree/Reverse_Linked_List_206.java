package tree;

import java.util.List;
import java.util.Stack;

/**
 * Created by ping.wu on 2017/1/19.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Reverse_Linked_List_206 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode result = reverseList(listNode1);
        System.out.println(1);
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> list = new Stack();
        list.push(head);
        head = head.next;
        while (head != null) {
            list.push(head);
            head = head.next;
        }
        ListNode newHead = list.pop();
        ListNode temp = newHead;
        temp.next = null;
        while (list.size() > 0) {
            ListNode tempNode = list.pop();
            temp.next = tempNode;
            tempNode.next = null;
            temp = tempNode;
        }
        return newHead;
    }
}
