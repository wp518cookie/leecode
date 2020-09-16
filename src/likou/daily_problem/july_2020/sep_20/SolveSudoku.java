package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-15
 * https://leetcode-cn.com/problems/sudoku-solver/
 * <p>
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * Note:
 * <p>
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 */

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SolveSudoku().solveSudoku(board);
    }

    public void solveSudoku(char[][] board) {
        boolean[][] rowMark = new boolean[9][9];
        boolean[][] colMark = new boolean[9][9];
        boolean[][] blockMark = new boolean[9][9];
        int count = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char t = board[i][j];
                int idx = t - '1';
                if (t == '.') {
                    count++;
                } else {
                    rowMark[i][idx] = true;
                    colMark[j][idx] = true;
                    blockMark[getBlockIdx(i, j)][idx] = true;
                }
            }
        }
        if (count == 0) {
            return;
        }
        recursion(board, count, 0, 0, rowMark, colMark, blockMark);
        System.out.println(123);
    }

    private void recursion(char[][] board, int rest, int rowStart, int colStart, boolean[][] rowMark, boolean[][] colMark, boolean[][] blockMark) {
        if (rest == 0) {
            return;
        }
        if (rowStart >= 9) {
            return;
        }
        for (int i = rowStart; i < 9; i++) {
            for (int j = colStart; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (rest == 0) {
                        return;
                    }
                    if (!check(i, j, k, rowMark, colMark, blockMark)) {
                        continue;
                    }
                    board[i][j] = (char) (k + '0');
                    setVal(i, j, k, rowMark, colMark, blockMark);
                    rest = rest - 1;
                    if (rest == 0) {
                        return;
                    }
                    if (j == 8) {
                        recursion(board, rest, i + 1, 0, rowMark, colMark, blockMark);
                    } else {
                        recursion(board, rest, i, j + 1, rowMark, colMark, blockMark);
                    }
                    reverseVal(i, j, k, rowMark, colMark, blockMark);
                    board[i][j] = '.';
                    rest = rest + 1;
                }
            }
        }
    }

    private int getBlockIdx(int i, int j) {
        return i / 3 + j / 3;
    }

    private boolean check(int i, int j, int val, boolean[][] rowMark, boolean[][] colMark, boolean[][] blockMark) {
        if (rowMark[i][val - 1]) {
            return false;
        }
        if (colMark[j][val - 1]) {
            return false;
        }
        if (blockMark[getBlockIdx(i, j)][val - 1]) {
            return false;
        }
        return true;
    }

    private void setVal(int i, int j, int val, boolean[][] rowMark, boolean[][] colMark, boolean[][] blockMark) {
        rowMark[i][val - 1] = true;
        colMark[j][val - 1] = true;
        blockMark[getBlockIdx(i, j)][val - 1] = true;
    }

    private void reverseVal(int i, int j, int val, boolean[][] rowMark, boolean[][] colMark, boolean[][] blockMark) {
        rowMark[i][val - 1] = false;
        colMark[j][val - 1] = false;
        blockMark[getBlockIdx(i, j)][val - 1] = false;
    }
}
