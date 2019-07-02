package medium;

/**
 * @author wuping
 * @date 2019-07-02
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */

public class Ship_within_days {
    public static void main(String[] args) {
        Ship_within_days ship_within_days = new Ship_within_days();
        int[] weights = new int[]{10,50,100,100,50,100,100,100};
        System.out.println(ship_within_days.shipWithinDays(weights, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int gap = (weights.length / D) + (weights.length % D == 0 ? 0 : 1);
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < weights.length; i++) {
            int t = weights[i];
            if (min < t) {
                min = t;
            }
            count += t;
            if ((i + 1) % gap == 0) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }
        }
        int start = min;
        int end = max;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            int result = judge(mid, D, weights);
            if (result < 0) {
                start = mid + 1;
            } else if (result >= 0) {
                if (judge(mid - 1, D, weights) < 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return start;
    }

    public int judge(int mid, int D, int[] weights) {
        int count = 1;
        int hold = mid;
        for (int i = 0; i < weights.length; i++) {
            if (count > D) {
                return -1;
            }
            if (hold >= weights[i]) {
                hold -= weights[i];
            } else {
                count++;
                hold = mid - weights[i];
            }
        }
        if (count > D) {
            return -1;
        }
        return count == D ? 0 : 1;
    }
}
