package likou.contest.contest_193;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-06-14
 * https://leetcode-cn.com/contest/weekly-contest-193/problems/minimum-number-of-days-to-make-m-bouquets/
 */

public class MinDays {
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        System.out.println(new MinDays().minDays(arr, m, k));
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int limit = m * k;
        if (limit > bloomDay.length) {
            return -1;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int i : bloomDay) {
            if (treeMap.containsKey(i)) {
                treeMap.put(i, treeMap.get(i) + 1);
            } else {
                treeMap.put(i, 1);
            }
        }
        int low = 0;
        int pre = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() + pre >= limit) {
                low = entry.getKey();
                break;
            } else {
                pre += entry.getValue();
                continue;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            list.add(entry.getKey());
        }
        int start = list.indexOf(low);
        int end = list.size() - 1;
        int result = recursion(bloomDay, start, end, m, k, list);
        if (result == -1) {
            return -1;
        }
        return list.get(result);
    }

    public int recursion(int[] bloomDay, int start, int end, int m, int k, List<Integer> list) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return check(bloomDay, list.get(start), m, k) ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (check(bloomDay, list.get(mid), m, k)) {
            return recursion(bloomDay, start, mid, m, k, list);
        } else {
            return recursion(bloomDay, mid + 1, end, m, k, list);
        }
    }

    public boolean check(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        for (int i = 0; i < bloomDay.length - k + 1;) {
            if (count >= m) {
                return true;
            }
            boolean flag = true;
            int j = i;
            for (; j < i + k; j++) {
                if (bloomDay[j] <= day) {
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                i = j;
            } else {
                i = j + 1;
            }
        }
        return count >= m;
    }
}
