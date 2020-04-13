package likou.first_try.top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wuping
 * @date 2020-04-11
 * https://leetcode-cn.com/problems/sort-integers-by-the-power-value/
 */

public class GetKth_1387 {
    private Map<Integer, Integer> cache = new HashMap();

    public int getKth(int lo, int hi, int k) {
        for (int i = lo; i <= hi; i++) {
            cache.put(i, recursion(i));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
            if (b.getRight() > a.getRight()) {
                return 1;
            } else if (b.getRight() < a.getRight()) {
                return -1;
            } else {
                return b.getLeft() - a.getLeft();
            }
        });
        for (int i = lo; i <= hi; i++) {
            if (pq.size() < k) {
                pq.offer(new Pair(i, cache.get(i)));
            } else {
                Pair max = pq.peek();
                if (max.getRight() > cache.get(i)) {
                    pq.poll();
                    pq.offer(new Pair(i, cache.get(i)));
                } else if (max.getRight() == cache.get(i)) {
                    if (max.getLeft() > i) {
                        pq.poll();
                        pq.offer(new Pair(i, cache.get(i)));
                    }
                }
            }
        }
        return pq.peek().getLeft();
    }

    public int recursion(int x) {
        if (x == 1) {
            return 0;
        }
        if (cache.containsKey(x)) {
            return cache.get(x);
        }
        boolean flag = x % 2 == 0;
        if (flag) {
            int result = recursion(x / 2) + 1;
            cache.put(x, result);
            return result;
        } else {
            int result = recursion(3 * x + 1) + 1;
            cache.put(x, result);
            return result;
        }
    }

    private static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }
}
