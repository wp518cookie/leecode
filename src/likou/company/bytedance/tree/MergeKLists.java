package likou.company.bytedance.tree;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wuping
 * @date 2020-06-09
 * <p>
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1025/
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

public class MergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(-1);
//        ListNode l3 = new ListNode(5);
//        l1.next = l2;
//        l2.next = l3;
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(3);
//        ListNode l6 = new ListNode(4);
//        l4.next = l5;
//        l5.next = l6;
//        ListNode l7 = new ListNode(2);
//        ListNode l8 = new ListNode(6);
//        l7.next = l8;
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
//        listNodes[1] = l4;
        listNodes[1] = null;
        listNodes[2] = l2;
        System.out.println(new MergeKLists().mergeKLists(listNodes).val);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        List<Pair> pairList = new ArrayList();
        for (int i = 1; i < lists.length; i = i + 2) {
            ListNode t1 = lists[i - 1];
            ListNode t2 = lists[i];
            pairList.add(merge(t1, t2));
        }
        if (lists.length % 2 != 0) {
            pairList.add(get(lists[lists.length - 1]));
        }
        while (pairList.size() > 1) {
            Collections.sort(pairList);
            List<Pair> newPairList = new ArrayList<>();
            for (int i = 1; i < pairList.size(); i = i + 2) {
                newPairList.add(merge(pairList.get(i), pairList.get(i - 1)));
            }
            if (pairList.size() % 2 != 0) {
                newPairList.add(pairList.get(pairList.size() - 1));
            }
            pairList = newPairList;
        }
        return pairList.get(0).result;
    }

    public Pair get(ListNode t) {
        int count = 0;
        ListNode cursor = t;
        while (cursor != null) {
            count++;
            cursor = cursor.next;
        }
        return new Pair(count, t);
    }

    public Pair merge(Pair p1, Pair p2) {
        return merge(p1.result, p2.result);
    }

    public Pair merge(ListNode t1, ListNode t2) {
        int count = 0;
        ListNode result = new ListNode(-1);
        ListNode t = result;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                t.next = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t2 = t2.next;
            }
            t = t.next;
            count++;
        }
        while (t1 != null) {
            t.next = t1;
            t1 = t1.next;
            t = t.next;
            count++;
        }
        while (t2 != null) {
            t.next = t2;
            t2 = t2.next;
            t = t.next;
            count++;
        }
        return new Pair(count, result.next);
    }

    private static class Pair implements Comparable<Pair> {
        int count;
        ListNode result;

        public Pair(int count, ListNode result) {
            this.count = count;
            this.result = result;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count == o.count) {
                return 0;
            }
            return this.count > o.count ? 1 : -1;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
