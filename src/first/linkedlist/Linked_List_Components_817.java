package first.linkedlist;

/**
 * @author wuping
 * @date 2019-10-01
 * https://leetcode.com/problems/linked-list-components/
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 */

public class Linked_List_Components_817 {

//    public static void main(String[] args) {
//        ListNode t1 = new ListNode(0);
//        ListNode t2 = new ListNode(1);
//        ListNode t3 = new ListNode(2);
//        ListNode t4 = new ListNode(3);
//        t1.next = t2;
//        t2.next = t3;
//        t3.next = t4;
//        int[] G = new int[]{0, 1, 3};
//        System.out.println(new Linked_List_Components_817().numComponents(t1, G));
//    }
//
//    public int numComponents(ListNode head, int[] G) {
//        int result = 0;
//        if (head == null || G == null || G.length < 2) {
//            return result;
//        }
//        Map<Integer, Integer> map = new HashMap();
//        ListNode cur = head;
//        while (cur.next != null) {
//            map.put(cur.val, cur.next.val);
//            cur = cur.next;
//        }
//        Set<Integer> Gset = new HashSet();
//        for (int i = 0; i < G.length; i++) {
//            Gset.add(G[i]);
//        }
//        for (int i : Gset) {
//            if (map.containsKey(i) && Gset.contains(map.get(i))) {
//                result++;
//            }
//        }
//        return result;
//    }
}
