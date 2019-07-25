package binary_search;

/**
 * @author wuping
 * @date 2019-07-25
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 */

public class Ship_Within_Days_1011 {
    public static void main(String[] args) {
        System.out.println(new Ship_Within_Days_1011().shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        for (int t : weights) {
            min = Math.max(min, t);
            max += t;
        }
        int start = min;
        int end = max;
        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (canShip(weights, D, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canShip(int[] weights, int D, int weight) {
        int count = 1;
        int t = weight;
        for (int i = 0; i < weights.length; i++) {
            if (count > D) {
                return false;
            }
            if (t - weights[i] < 0) {
                t = weight - weights[i];
                count++;
            } else {
                t = t - weights[i];
            }
        }
        return count <= D;
    }
}
