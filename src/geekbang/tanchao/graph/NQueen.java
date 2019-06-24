package geekbang.tanchao.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-06-21
 * https://leetcode.com/problems/n-queens/
 */

public class NQueen {
    public static void main(String[] args) {
        NQueen queen = new NQueen();
        List<List<String>> result = queen.solveNQueens(4);
        System.out.println(result.size());
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList();
        if (n == 1) {
            List<String> q = new ArrayList<>();
            q.add("Q");
            result.add(q);
            return result;
        }
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int t = 0;
            while (t < n) {
                if (t == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
                t++;
            }
            s[i] = sb.toString();
        }
        List<List<Integer>> lists = new ArrayList();
        for (int i = 0; i < n; i++) {
            List<Integer> meta = new ArrayList();
            int[][] boards = new int[n][n];
            cut(0, i, boards, n);
            meta.add(i);
            solveNQueensRecursion(1, n, boards, meta, lists);
        }
        for (List<Integer> t : lists) {
            List<String> m = new ArrayList();
            for (int i : t) {
                m.add(s[i]);
            }
            result.add(m);
        }
        return result;
    }

    public void solveNQueensRecursion(int start, int n, int[][] boards, List<Integer> meta, List<List<Integer>> result) {
        if (start >= n) {
            return;
        }
        // last one
        if (start == n - 1) {
            for (int i = 0; i < n; i++) {
                if (boards[start][i] != -1) {
                    meta.add(i);
                    result.add(new ArrayList(meta));
                    meta.remove(meta.size() - 1);
                }
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (boards[start][i] == -1) {
                continue;
            }
            meta.add(i);
            int[][] newBoards = new int[n][n];
            for (int k = 0; k < n; k++) {
                newBoards[k] = Arrays.copyOf(boards[k], n);
            }
            cut(start, i, newBoards, n);
            solveNQueensRecursion(start + 1, n, newBoards, meta, result);
            meta.remove(meta.size() - 1);
        }
    }

    public void cut(int rowIdx, int colIdx, int[][] boards, int n) {
        for (int j = 0; j < n; j++) {
            boards[j][colIdx] = -1;
        }
        // 右下
        int r2 = rowIdx + 1;
        int c2 = colIdx + 1;
        while (r2 < n && c2 < n) {
            boards[r2][c2] = -1;
            r2++;
            c2++;
        }
        // 左下
        int r3 = rowIdx + 1;
        int c3 = colIdx - 1;
        while (r3 < n && c3 >= 0) {
            boards[r3][c3] = - 1;
            r3++;
            c3--;
        }
    }
}
