package medium;

/**
 * Created by Administrator on 2017/10/26.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Remove_Nth_Node_From_End_of_List_19 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode result = removeNthFromEnd(l1, 1);
        while (result != null) {
            System.out.println(result.val);
            result =result.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int position = length - n;
        if (position < 0) {
            return head;
        } else if (position == 0) {
            return head.next;
        } else {
            ListNode prev = head;
            temp = head.next;
            while (position-- > 1) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
        return head;
    }
}
