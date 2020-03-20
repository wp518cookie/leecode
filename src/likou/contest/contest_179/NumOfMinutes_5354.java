package likou.contest.contest_179;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-03-08
 * https://leetcode-cn.com/contest/weekly-contest-179/problems/time-needed-to-inform-all-employees/
 */

public class NumOfMinutes_5354 {
    /**
     * @param n          员工数
     * @param headID     总负责人id
     * @param manager    负责人id
     * @param informTime 通知时间
     * @return
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return 0;
        }
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList();
        }
        for (int i = 0; i < manager.length; i++) {
            int val = manager[i];
            if (val != -1) {
                list[val].add(i);
            }
        }
        int[] count = new int[n];
        Queue<Integer> queue = new LinkedList();
        queue.offer(headID);
        int size = queue.size();
        while (!queue.isEmpty()) {
            int newSize = 0;
            while (size > 0) {
                Integer head = queue.poll();
                List<Integer> meatL = list[head];
                for (Integer t : meatL) {
                    count[t] = count[head] + informTime[head];
                    if (list[t].size() > 0) {
                        newSize++;
                        queue.offer(t);
                    }
                }
                size--;
            }
            size = newSize;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, count[i]);
        }
        return result;
    }
}
