package first.linkedlist;

/**
 * Created by ping.wu on 2016/12/20.
 */
public class Odd_Even_Linked_List_328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode temp = head;
        int count = 1;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(temp.val);
        temp = temp.next;
        count++;
        ListNode evenHead = new ListNode(temp.val);
        temp = temp.next;
        if (temp == null) {
            oddHead.next = evenHead;
            return oddHead;
        }
        ListNode temp_oddList = oddHead;
        ListNode temp_evenList = evenHead;
        while (temp != null) {
            if (count % 2 == 0) {
                temp_oddList.next = temp;
                temp_oddList = temp_oddList.next;
            } else {
                temp_evenList.next = temp;
                temp_evenList = temp_evenList.next;
            }
            temp = temp.next;
            count++;
            if (temp == null) {
                temp_evenList.next = null;
                temp_oddList.next = evenHead;
                break;
            }
        }
        return oddHead;
    }
}
