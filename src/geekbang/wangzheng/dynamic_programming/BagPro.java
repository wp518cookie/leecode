package geekbang.wangzheng.dynamic_programming;

/**
 * @author wuping
 * @date 2020-09-30
 * private int maxV = Integer.MIN_VALUE;
 * 结果放到maxV中private int[] items = {2，2，4，6，3};
 * 物品的重量private int[] value = {3，4，8，9，6};
 * 物品的价值private int n = 5;
 * 物品个数private int w = 9; // 背包承受的最大重量
 */

public class BagPro {
    private int maxValue = 0;

    public void countRecursion(int[] weights, int[] value, int start, int n, int w, int currentWeight, int currentVal) {
        if (currentVal > maxValue) {
            maxValue = currentVal;
        }
        if (start >= n) {
            return;
        }
        for (int i = start; i < weights.length; i++) {
            if (currentWeight + weights[i] > w) {
                continue;
            }
            countRecursion(weights, value, i + 1, n, w, currentWeight + weights[i], currentVal + value[i]);
        }
    }

    public int countDp(int[] weights, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                states[i][j] = -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
