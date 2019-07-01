package geekbang.tanchao.sudoku;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-06-27
 */

public class SolveSudoku {
    private static char[][] result = new char[9][9];
    private static boolean successFlag = false;

    public static void main(String[] args) {
        char[][] t = new char[9][9];
        t[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        t[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        t[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        t[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        t[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        t[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        t[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        t[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        t[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        solveSudoku(t);
    }

    public static void solveSudoku(char[][] board) {
        byte[][] row = new byte[9][9];
        byte[][] col = new byte[9][9];
        byte[][] block = new byte[9][9];
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                int val = ((int) t) - 49;
                row[i][val] = 1;
                col[j][val] = 1;
                int blockRow = i / 3;
                int blockCol = j / 3;
                block[blockRow * 3 + blockCol][val] = 1;
            }
        }
        int nextCol = nextCol(0, 0, board);
        solveSudoku(0, nextCol, row, col, block, board);
    }

    public static void solveSudoku(int startRow, int startCol, byte[][] row, byte[][] col, byte[][] block, char[][] board) {
        if (successFlag) {
            return;
        }
        if (startRow == 8 && startCol == 8) {
            if (board[startRow][startCol] == '.') {
                for (int k = 0; k < 9; k++) {
                    if (row[startRow][k] == 0) {
                        board[startRow][startCol] = (char) (k + 49);
                        successFlag = true;
                        return;
                    }
                }
            } else {
                successFlag = true;
                return;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (judge(startRow, startCol, k, row, col, block)) {
                set(startRow, startCol, k, row, col, block, board);
                int nextCol = nextCol(startRow, startCol + 1, board);
                int t = startRow;
                if (nextCol < 0) {
                    do {
                        t++;
                        if (t > 8) {
                            successFlag = true;
                            return;
                        }
                        nextCol = nextCol(t, 0, board);
                    } while (nextCol < 0);
                }
                solveSudoku(t, nextCol, row, col, block, board);
                if (successFlag) {
                    return;
                }
                rollback(startRow, startCol, k, row, col, block, board);
            }
        }
    }


    public static int nextCol(int startRow, int startCol, char[][] board) {
        for (int i = startCol; i < 9; i++) {
            if (board[startRow][i] == '.') {
                return i;
            }
        }
        return -1;
    }

    public static boolean judge(int rowIdx, int colIdx, int val, byte[][] row, byte[][] col, byte[][] block) {
        return row[rowIdx][val] == 0 && col[colIdx][val] == 0 && block[(rowIdx / 3 * 3) + (colIdx / 3)][val] == 0;
    }

    public static void set(int rowIdx, int colIdx, int val, byte[][] row, byte[][] col, byte[][] block, char[][] board) {
        row[rowIdx][val] = 1;
        col[colIdx][val] = 1;
        block[rowIdx / 3 * 3 + colIdx / 3][val] = 1;
        board[rowIdx][colIdx] = (char) (val + 49);
    }

    public static void rollback(int rowIdx, int colIdx, int val, byte[][] row, byte[][] col, byte[][] block, char[][] board) {
        row[rowIdx][val] = 0;
        col[colIdx][val] = 0;
        block[rowIdx / 3 * 3 + colIdx / 3][val] = 0;
        board[rowIdx][colIdx] = '.';
    }
}
