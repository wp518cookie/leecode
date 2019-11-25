package first.linkedlist;

/**
 * Created by ping.wu on 2016/11/18.
 */

public class Sort_List_148 {
    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode result = sortList(listNode2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head!= null) {
            ListNode endNode = null;
            ListNode preNode = null;
            ListNode temp = head.next;
            while(temp != endNode) {
                if (head.val > temp.val) {
                    temp = change(preNode,head);
                }
                preNode = temp;
                if (temp.next == endNode) {
                    endNode = temp;
                }
                temp = temp.next;
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode change(ListNode preNode, ListNode first) {
        ListNode second = first.next;
        if (preNode == null) {
            preNode = new ListNode(first.next.val);
            preNode.next = first;
            first.next = second.next;
            return preNode;
        } else {
            first.next = second.next;
            second.next = first;
            preNode.next = second;
            return preNode;
        }
    }
}