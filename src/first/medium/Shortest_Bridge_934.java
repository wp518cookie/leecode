//package first.medium;
//
//import javafx.util.Pair;
//
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
///**
// * @author wuping
// * @date 2020-01-03
// * https://leetcode.com/problems/shortest-bridge/
// */
//
//public class Shortest_Bridge_934 {
//    public int shortestBridge(int[][] A) {
//        int mark = 2;
//        int row = A.length;
//        int col = A[0].length;
//        Queue<Pair<Integer, Integer>> queue = new LinkedList();
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A[0].length; j++) {
//                if (A[i][j] == 1) {
//                    queue.offer(new Pair(i, j));
//                    dfs(A, i, j, mark, row, col, queue);
//                    mark++;
//                }
//            }
//        }
//        int size = queue.size();
//        int step = 1;
//        while (size > 0) {
//            int newSize = 0;
//            while (size-- > 0) {
//                Pair<Integer, Integer> pair = queue.poll();
//                int x = pair.getKey();
//                int y = pair.getValue();
//                if (x > 0) {
//                    if (A[x - 1][y] == 0) {
//                        A[x - 1][y] = 2;
//                        queue.offer(new Pair(x - 1, y));
//                        newSize++;
//                    } else if (A[x - 1][y] == 3) {
//                        return step;
//                    }
//                }
//                if (x < row - 1) {
//                    if (A[x + 1][y] == 0) {
//                        A[x + 1][y] = 2;
//                        queue.offer(new Pair(x + 1, y));
//                        newSize++;
//                    } else if (A[x + 1][y] == 3) {
//                        return step;
//                    }
//                }
//                if (y > 0) {
//                    if (A[x][y - 1] == 0) {
//                        A[x][y - 1] = 2;
//                        queue.offer(new Pair(x, y - 1));
//                        newSize++;
//                    } else if (A[x][y - 1] == 3) {
//                        return step;
//                    }
//                }
//
//            }
//        }
//    }
//
//    private void dfs(int[][] A, int x, int y, int mark, int row, int col, Queue queue) {
//        if (x < 0 || x >= row) {
//            return;
//        }
//        if (y < 0 || y >= col) {
//            return;
//        }
//        if (A[x][y] != 1) {
//            return;
//        }
//        A[x][y] = mark;
//        if (mark == 2) {
//            queue.offer(new Pair(x, y));
//        }
//        dfs(A, x - 1, y, mark, row, col, queue);
//        dfs(A, x + 1, y, mark, row, col, queue);
//        dfs(A, x, y - 1, mark, row, col, queue);
//        dfs(A, x, y + 1, mark, row, col, queue);
//    }
//}
