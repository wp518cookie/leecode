package likou.contest.contest_186;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-26
 * https://leetcode-cn.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
 */

public class FindDiagonalOrder_5394 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList();
        List<Integer> t1 = new ArrayList<>();
        t1.add(1);
        t1.add(2);
        t1.add(3);
        List<Integer> t2 = new ArrayList<>();
        t2.add(4);
        t2.add(5);
        t2.add(6);
        List<Integer> t3 = new ArrayList<>();
        t3.add(7);
        t3.add(8);
        t3.add(9);
        nums.add(t1);
        nums.add(t2);
        nums.add(t3);
        System.out.println(Arrays.toString(new FindDiagonalOrder_5394().findDiagonalOrder(nums)));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> result = new ArrayList();
        int[] marked = new int[nums.size()];
        int count = 0;
        List<Integer> next = new ArrayList();
        next.add(nums.get(0).get(0));
        for (int i = 0; i < marked.length; i++) {
            marked[i] = count--;
        }
        while (next.size() > 0) {
            for (int i = next.size() - 1; i >= 0; i--) {
                result.add(next.get(i));
            }
            next = new ArrayList();
            for (int i = 0; i < marked.length; i++) {
                int t = ++marked[i];
                if (t >= 0 && t < nums.get(i).size()) {
                    next.add(nums.get(i).get(t));
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}
