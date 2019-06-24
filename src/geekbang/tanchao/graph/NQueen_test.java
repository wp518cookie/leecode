package geekbang.tanchao.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2019-06-24
 */

public class NQueen_test {
    public static void main(String[] args) {
        NQueen_test t = new NQueen_test();
        t.solveNQueens(4);
        System.out.println(123);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> lists = new ArrayList();
        if (n == 1) {
            List<String> q = new ArrayList<>();
            q.add("Q");
            lists.add(q);
            return lists;
        }
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < n; i++) {
            byte[] arr = new byte[n * n];
            List<Integer> meta = new ArrayList();
            meta.add(i);
            setState(0, i, arr, n);
            backTrace(1, arr, n, meta, result);
        }
        for (List<Integer> m : result) {
            List<String> ms = new ArrayList<>();
            int row = 0;
            for (int i : m) {
                StringBuilder sb = new StringBuilder();
                for (int k = row * n; k < (row + 1) * n; k++) {
                    if (k == i) {
                        sb.append('Q');
                    } else {
                        sb.append(".");
                    }
                }
                row++;
                ms.add(sb.toString());
            }
            lists.add(ms);

        }
        return lists;
    }

    private void backTrace(int start, byte[] arr, int n, List<Integer> meta, List<List<Integer>> result) {
        int endIdx = (start + 1) * n;
        int startIdx = start * n;
        if (start == n - 1) {
            for (int i = startIdx; i < endIdx; i++) {
                if (arr[i] == 0) {
                    meta.add(i);
                    result.add(new ArrayList<>(meta));
                    meta.remove(meta.size() - 1);
                }
            }
            return;
        }
        for (int i = startIdx; i < endIdx; i++) {
            if (arr[i] == 1) {
                continue;
            }
            meta.add(i);
            byte[] newArr = Arrays.copyOf(arr, arr.length);
            setState(start, i - startIdx, newArr, n);
            backTrace(start + 1, newArr, n, meta, result);
            meta.remove(meta.size() - 1);
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
