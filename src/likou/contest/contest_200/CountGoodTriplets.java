package likou.contest.contest_200;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-08-02
 * https://leetcode-cn.com/contest/weekly-contest-200/problems/count-good-triplets/
 * <p>
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 * <p>
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 * <p>
 * 返回 好三元组的数量 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */

public class CountGoodTriplets {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 1, 1, 9, 7};
        System.out.println(new CountGoodTriplets().countGoodTriplets(arr, 7, 2, 3));
    }
    private int result = 0;
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return 0;
        }
        if (arr.length < 3) {
            return 0;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            recursion(arr, arr[i], 0, i + 1, a, b, c, 2);
        }
        return result;
    }

    public void recursion(int[] arr, int first, int second, int start, int a, int b, int c, int count) {
        if (count == 1) {
            for (int i = start; i < arr.length; i++) {
                int t = arr[i];
                if (((first - t) <= c && (t - first) <= c)
                    && ((second - t) <= b && (t - second) <= b)) {
                    result++;
                }
            }
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (first - arr[i] > a || arr[i] - first > a) {
                continue;
            }
            recursion(arr, first, arr[i], i + 1, a, b, c, 1);
        }
    }
}
