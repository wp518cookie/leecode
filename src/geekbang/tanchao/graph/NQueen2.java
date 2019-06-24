package geekbang.tanchao.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-06-24
 */

public class NQueen2 {
    private int count = 0;

    public static void main(String[] args) {
        NQueen2 nQueen2 = new NQueen2();
        int result = nQueen2.totalNQueens(4);
        System.out.println(result);
    }

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            byte[] arr = new byte[n * n];
            setState(0, i, arr, n);
            backTrace(1, arr, n);
        }
        return count;
    }

    /**
     * 回溯算法
     * @param start
     * @param arr
     * @param n
     */
    private void backTrace(int start, byte[] arr, int n) {
        int endIdx = (start + 1) * n;
        int startIdx = start * n;
        if (start == n - 1) {
            for (int i = startIdx; i < endIdx; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            return;
        }
        for (int i = startIdx; i < endIdx; i++) {
            if (arr[i] == 1) {
                continue;
            }
            byte[] newArr = Arrays.copyOf(arr, arr.length);
            setState(start, i - startIdx, newArr, n);
            backTrace(start + 1, newArr, n);
        }
    }

    private void setState(int rowIdx, int colIdx, byte[] arr, int n) {
        // 竖立方向
        int r1 = rowIdx;
        while (r1 < n) {
            arr[r1 * n + colIdx] = 1;
            r1++;
        }
        // 左下方向
        int r2 = rowIdx + 1;
        int c2 = colIdx - 1;
        while (r2 < n && c2 >= 0) {
            arr[r2 * n + c2] = 1;
            r2++;
            c2--;
        }
        // 右下方向
        int r3 = rowIdx + 1;
        int c3 = colIdx + 1;
        while (r3 < n && c3 < n) {
            arr[r3 * n + c3] = 1;
            r3++;
            c3++;
        }
    }
}
