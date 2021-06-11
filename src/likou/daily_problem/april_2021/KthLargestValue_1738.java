package likou.daily_problem.april_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wuping
 * @date 2021-05-19
 * https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * <p>
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * <p>
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * <p>
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 1
 * 输出：7
 * 解释：坐标 (0,1) 的值是 5 XOR 2 = 7 ，为最大的值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 2
 * 输出：5
 * 解释：坐标 (0,0) 的值是 5 = 5 ，为第 2 大的值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 3
 * 输出：4
 * 解释：坐标 (1,0) 的值是 5 XOR 1 = 4 ，为第 3 大的值。
 * 示例 4：
 * <p>
 * 输入：matrix = [[5,2],[1,6]], k = 4
 * 输出：0
 * 解释：坐标 (1,1) 的值是 5 XOR 2 XOR 1 XOR 6 = 0 ，为第 4 大的值。
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 0 <= matrix[i][j] <= 106
 * 1 <= k <= m * n
 */

public class KthLargestValue_1738 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 9, 5}, {2, 0, 4}, {1, 0, 9}, {3, 4, 8}};
        System.out.println(new KthLargestValue_1738().kthLargestValue(arr, 10));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        result[i][j] = matrix[i][j];
                        continue;
                    } else {
                        result[i][j] = result[i][j - 1] ^ matrix[i][j];
                    }
                } else if (j == 0) {
                    result[i][j] = result[i - 1][j] ^ matrix[i][j];
                } else {
                    result[i][j] = result[i - 1][j - 1] ^ matrix[i][j] ^ matrix[i - 1][j] ^ matrix[i][j - 1];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                list.add(result[i][j]);
            }
        }
        list.sort((a, b) -> b - a);
        System.out.println(list.get(9));
        int count = matrix.length * matrix[0].length;
//        if (k < count / 2) {
        return findKlargest(result, k);
//        } else {
//            return findKSmallest(result, count - k - 1);
//        }
    }

    public int findKlargest(int[][] t, int k) {
        int size = 0;
        int[] arr = new int[k + 1];
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if (size < k) {
                    arr[1 + size] = t[i][j];
                    size++;
                    siftUp(arr, size);
                } else {
                    if (arr[1] < t[i][j]) {
                        arr[1] = t[i][j];
                        siftDown(arr);
                    } else {
                        continue;
                    }
                }
            }
        }
        return arr[1];
    }


    public void siftUp(int[] arr, int k) {
        int t = arr[k];
        while (k > 1) {
            int parent = k / 2;
            if (arr[parent] > t) {
                arr[k] = arr[parent];
                k = parent;
            } else {
                break;
            }
        }
        arr[k] = t;
    }

    public void siftDown(int[] arr) {
        int t = arr[1];
        int k = 1;
        int limit = arr.length / 2 + ((arr.length % 2 == 0) ? -1 : 0);
        while (k <= limit) {
            int idx = k * 2;
            if (idx + 1 < arr.length) {
                idx = arr[idx] < arr[idx + 1] ? idx : idx + 1;
            }
            if (arr[idx] < t) {
                arr[k] = arr[idx];
                k = idx;
            } else {
                break;
            }
        }
        arr[k] = t;
    }
}
