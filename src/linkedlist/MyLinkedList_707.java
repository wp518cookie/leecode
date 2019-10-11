package linkedlist;

/**
 * @author wuping
 * @date 2019-09-25
 * https://leetcode.com/problems/design-linked-list/
 */

public class MyLinkedList_707 {
    private Node head;
    private Node tail;
    /** Initialize your data structure here. */
    private static class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList_707() {
        this.head = new Node(-1, null, null);
        this.tail = new Node(-1, head, null);
        head.next = tail;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        Node cursor = head.next;
        int count = 0;
        while (cursor != tail) {
            if (count == index) {
                return cursor.val;
            }
            count++;
            cursor = cursor.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node added = new Node(val, head, head.next);
        head.next.prev = added;
        head.next = added;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node added = new Node(val, tail.prev, tail);
        tail.prev.next = added;
        tail.prev = added;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            return;
        }
        int count = 0;
        Node cursor = head.next;
        while (cursor != tail) {
            if (count == index) {
                Node added = new Node(val, cursor.prev, cursor);
                cursor.prev.next = added;
                cursor.prev = added;
            }
            count++;
            cursor = cursor.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            return;
        }
        int count = 0;
        Node cursor = head.next;
        while (cursor != tail) {
            if (count == index) {
                cursor.next.prev = cursor.prev;
                cursor.prev.next = cursor.next;
                cursor.prev = null;
                cursor.next = null;
                return;
            }
            count++;
            cursor = cursor.next;
        }
    }

    public static void main(String[] args) {
        /**
         * ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
         * [[],[1],[3],[1,2],[1],[1],[1]]
         */
        MyLinkedList_707 list = new MyLinkedList_707();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}
