package likou.contest_180;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wuping
 * @date 2020-03-15
 * 6
 * [2,10,3,1,5,8]
 * [5,4,3,9,7,2]
 * 2
 */

public class MaxPerformance_5359 {
    public static void main(String[] args) {
        int[] speed = new int[]{2,8,2};
        int[] efficiency = new int[]{2,7,1};
        System.out.println(new MaxPerformance_5359().maxPerformance(3, speed, efficiency, 2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int tEff = efficiency[i];
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);
            for (int j = 0; j < n; j++) {
                if (efficiency[j] < tEff) {
                    continue;
                }
                if (queue.size() == k) {
                    if (queue.peek() > speed[j]) {
                        continue;
                    } else {
                        queue.poll();
                        queue.offer(speed[j]);
                    }
                } else {
                    queue.offer(speed[j]);
                }
            }
            map.put(tEff, queue);
        }
        Map<Long, Long> result = new HashMap();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            long tSpeed = entry.getKey();
            PriorityQueue<Integer> queue = entry.getValue();
            long sum = 0;
            for (Integer t : queue) {
                sum += t;
            }
            result.put(tSpeed, sum);
        }
        Map<Long, Long> result1 = new HashMap();
        long t1 = Long.MIN_VALUE;
        for (Map.Entry<Long, Long> entry : result.entrySet()) {
            long t = getZero(entry.getKey()) + getZero(entry.getValue());
            if (t > t1) {
                result1 = new HashMap();
                result1.put(entry.getKey(), entry.getValue());
                t1 = t;
            } else if (t == t1) {
                result1.put(entry.getKey(), entry.getValue());
            } else {
                continue;
            }
        }
        long number = 1000000007;
        long before1 = Long.MIN_VALUE;
        long before2 = Long.MIN_VALUE;
        for (Map.Entry<Long, Long> entry : result1.entrySet()) {
            long tb1 = entry.getKey() / number;
            long tb2 = entry.getKey() % number;
            long tb3 = entry.getValue() / number;
            long tb4 = entry.getValue() % number;
            tb1 = tb1 + tb3;
            long tb5 = tb2 * tb4;
            if (tb5 > number) {
                tb1 += tb5 / number;
                tb2 = tb5 % number;
            } else {
                tb2 *= tb4;
            }
            if (before1 > tb1) {
                continue;
            } else if (before1 < tb1) {
                before1 = tb1;
                before2 = tb2;
            } else {
                if (before2 < tb2) {
                    before2 = tb2;
                }
            }
        }
        return (int) before2;
    }

    private int getZero(long t) {
        int result = 1;
        if (t == 10) {
            return result;
        }
        t = t / 10;
        while (t > 1) {
            result++;

            t = t / 10;
        }
        return result;
    }
}
