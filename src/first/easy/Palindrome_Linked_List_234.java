package first.easy;

/**
 * Created by Administrator on 2017/4/12.
 */
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}

public class Palindrome_Linked_List_234 {
    private static ListNode preNode;
    private static ListNode nextNode;
    private static int size = 1;
    private static ListNode end;
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }
        int count = size;
        temp = head;
        while (count-- > 0) {
            if (count > size / 2) {
                preNode = temp;
                temp = temp.next;
            } else {
                nextNode = temp.next;
                temp.next = preNode;
                preNode = temp;
                temp = nextNode;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        isPalindrome(l1);
    }
}
