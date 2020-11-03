package likou.daily_problem.july_2020.nov_20;

/**
 * @author wuping
 * @date 2020-11-03
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 */

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        if (A[1] <= A[0]) {
            return false;
        }
        boolean flag = true;
        for (int i = 2; i < A.length; i++) {
            if (flag) {
                int t = A[i] - A[i - 1];
                if (t < 0) {
                    flag = false;
                } else if (t == 0) {
                    return false;
                }
            } else {
                int t = A[i] - A[i - 1];
                if (t >= 0) {
                    return false;
                }
            }
        }
        return !flag;
    }
}
