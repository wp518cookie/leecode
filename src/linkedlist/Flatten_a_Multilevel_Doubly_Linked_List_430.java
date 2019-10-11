package linkedlist;

/**
 * @author wuping
 * @date 2019-10-01
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/submissions/
 * Flatten a Multilevel Doubly Linked List
 */

public class Flatten_a_Multilevel_Doubly_Linked_List_430 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1, null, head, null);
        Node c = new Node(head.val, null, null, null);
        dummy.next = c;
        Node current = c;
        Node t = head;
        if (t.child != null) {
            current.next = new Node(t.child.val, current, null, null);
            current = current.next;
            current = flattenInternal(t.child, current);
        }
        if (t.next != null) {
            current.next = new Node(t.next.val, current, null, null);
            current = current.next;
            flattenInternal(t.next, current);
        }
        return dummy.next;
    }

    public Node flattenInternal(Node t, Node current) {
        if (t.child != null) {
            current.next = new Node(t.child.val, current, null, null);
            current = current.next;
            current = flattenInternal(t.child, current);
        }
        if (t.next != null) {
            current.next = new Node(t.next.val, current, null, null);
            current = current.next;
            current = flattenInternal(t.next, current);
        }
        return current;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }
}