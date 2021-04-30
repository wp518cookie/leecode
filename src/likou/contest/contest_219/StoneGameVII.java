package likou.contest.contest_219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-12-13
 * https://leetcode-cn.com/contest/weekly-contest-219/problems/stone-game-vii/
 * <p>
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 */

public class StoneGameVII {
    private Map<Pair, Integer> map = new HashMap();

    public static void main(String[] args) {
        int[] arr = {7, 90, 5, 1, 100, 10, 10, 2};
        System.out.println(new StoneGameVII().stoneGameVII(arr));
    }

    public int stoneGameVII(int[] stones) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            count += stones[i];
        }
        return find(stones, 0, stones.length - 1, true, 0, count);
    }

    public int find(int[] stones, int i, int j, boolean ifAlice, int current, int count) {
        if (i == j) {
            return current;
        }
        if (ifAlice) {
//            Pair pair = new Pair(i, j);
//            if (maxMap.containsKey(pair)) {
//                return maxMap.get(pair);
//            }
            int t1 = 0;
            Pair p1 = new Pair(i + 1, j, !ifAlice);
            Pair p2 = new Pair(i, j - 1, !ifAlice);
            if (map.containsKey(p1)) {
                t1 = map.get(p1);
            } else {
                t1 = find(stones, i + 1, j, !ifAlice, current + count - stones[i], count - stones[i]);
                map.put(p1, t1);
            }
            int t2 = 0;
            if (map.containsKey(p2)) {
                t2 = map.get(p2);
            } else {
                t2 = find(stones, i, j - 1, !ifAlice, current + count - stones[j], count - stones[j]);
                map.put(p2, t2);
            }
            return Math.max(t1, t2);
        } else {
            Pair p1 = new Pair(i + 1, j, !ifAlice);
            Pair p2 = new Pair(i, j - 1, !ifAlice);
            int t1 = 0;
            int t2 = 0;
            if (map.containsKey(p1)) {
                t1 = map.get(p1);
            } else {
                t1 = find(stones, i + 1, j, !ifAlice, current - count + stones[i], count - stones[i]);
                map.put(p1, t1);
            }
            if (map.containsKey(p2)) {
                t2 = map.get(p2);
            } else {
                t2 = find(stones, i, j - 1, !ifAlice, current - count + stones[j], count - stones[j]);
                map.put(p2, t2);
            }
            return Math.max(t1, t2);
        }
    }

    private static class Pair {
        int i;
        int j;
        boolean ifAlice;

        public Pair(int i, int j, boolean ifAlice) {
            this.i = i;
            this.j = j;
            this.ifAlice = ifAlice;
        }

        @Override
        public int hashCode() {
            return (ifAlice ? 1 << 31 : 1 << 30) + i << 16 + j;
        }

        @Override
        public boolean equals(Object p) {
            if (!(p instanceof Pair)) {
                return false;
            }
            Pair t = (Pair) p;
            return t.ifAlice == ifAlice && t.i == i && t.j == j;
        }
    }
}
