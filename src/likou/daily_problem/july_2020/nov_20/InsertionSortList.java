package likou.daily_problem.july_2020.nov_20;

/**
 * @author wuping
 * @date 2020-11-20
 * https://leetcode-cn.com/problems/insertion-sort-list/
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 */

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = head;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = null;
            insertIntoSortedList(dummy,  cursor);
            cursor = next;
        }
        return dummy.next;
    }

    private void insertIntoSortedList(ListNode dummy, ListNode node) {
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            if (cur.val <= node.val) {
                pre = cur;
                cur = cur.next;
            } else {
                break;
            }
        }
        node.next = pre.next;
        pre.next = node;
    }

    public ListNode insertionSortList1(ListNode head) {
        //prev node dummyHead prev代表第一个，node代表第二个 对比 比较 dummyHead.next 挂head
        //prev.val跟node.val 如果prev.val > node.val 那么就生成temp 从dummyHead开始循环
        //一致比较temp.next.val跟node.val比较 如果temp.next.val一直小于node.val 就不断后移指针
        //否则跳出循环，把node.next赋给prev.next，把temp.next赋给node.next，把node赋给temp.next
        //把pre.next赋给node
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = head;
        ListNode node = head.next;
        while(node != null){
            if(prev.val > node.val){
                ListNode temp = dummyHead;
                while(temp.next.val < node.val){
                    temp = temp.next;
                }
                prev.next = node.next;
                node.next = temp.next;
                temp.next = node;
                node = prev.next;
            }else{
                prev = prev.next;
                node = node.next;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
