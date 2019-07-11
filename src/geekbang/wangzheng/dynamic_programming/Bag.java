package geekbang.wangzheng.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-11
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少
 */

public class Bag {
    private int max = Integer.MIN_VALUE;
    private List<Integer> result = new ArrayList();

    public static void main(String[] args) {
        int[] things = new int[]{2, 2, 4, 6, 3};
        int weight = 9;
        System.out.println(new Bag().countByDp(things, 5, weight));
    }

    public int count(int[] things, int weight) {
        countByRecursion(things, 0, 0, weight, new ArrayList());
        System.out.println(max);
        for (int t : result) {
            System.out.print(t);
        }
        return max;
    }

    // if use recursion, 可以加上备忘录来优化
    public void countByRecursion(int[] things, int start, int currentWeight, int weight, List<Integer> nums) {
        if (currentWeight > max) {
            max = currentWeight;
            result = new ArrayList(nums);
        }
        for (int i = start; i <things.length; i++) {
            int val = things[i];
            if (val + currentWeight > weight) {
                return;
            }
            nums.add(val);
            countByRecursion(things, i + 1, val + currentWeight, weight, nums);
            nums.remove(nums.size() - 1);
        }
    }

    /**
     * if use dynamic programming
     * 2 2 4 8 3       5        9
     * @param weight    物品重量
     * @param n     物品个数
     * @param w     背包可承载重量
     */
    public int countByDp(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <=w - weight[i]; ++j) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }
}
