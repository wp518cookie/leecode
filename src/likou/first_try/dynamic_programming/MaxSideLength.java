package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-09-22
 * https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 * <p>
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold <= 10^5
 */

public class MaxSideLength {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
        System.out.println(new MaxSideLength().maxSideLength(arr, 4));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sumArr = new int[m][n];
        sumArr[0][0] = mat[0][0];
        boolean flag = false;
        for (int i = 1; i < m; i++) {
            sumArr[i][0] = sumArr[i - 1][0] + mat[i][0];
            if (threshold >= mat[i][0]) {
                flag = true;
            }
        }
        for (int i = 1; i < n; i++) {
            sumArr[0][i] = sumArr[0][i - 1] + mat[0][i];
            if (threshold >= mat[0][i]) {
                flag = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + mat[i][j];
                if (threshold >= mat[i][j]) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            return 0;
        }
        int k = 0;
        flag = false;
        while (true) {
            int newK = k + 1;
            for (int i = newK; i < m; i++) {
                if (flag) {
                    break;
                }
                for (int j = newK; j < n; j++) {
                    int t = sumArr[i][j];
                    if (i - newK - 1 >= 0 && j - newK - 1 >= 0) {
                        t += sumArr[i - newK - 1][j - newK - 1];
                    }
                    if (t <= threshold) {
                        flag = true;
                        break;
                    }
                    if (i - newK - 1 >= 0) {
                        t -= sumArr[i - newK - 1][j];
                    }
                    if (j - newK - 1 >= 0) {
                        t -= sumArr[i][j - newK - 1];
                    }
                    if (t <= threshold) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                k = newK;
                flag = false;
            } else {
                return k + 1;
            }
        }
    }
}
