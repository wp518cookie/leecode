package geekbang.tanchao.sudoku;

/**
 * @author wuping
 * @date 2019-06-25
 * https://leetcode.com/problems/valid-sudoku/description/
 */

public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] boards = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(boards));
    }
    public static boolean isValidSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        byte[][] row = new byte[9][9];
        byte[][] col = new byte[9][9];
        byte[][] block = new byte[9][9];
        // 行判断
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                // 行判断
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                int val = ((int) t) - 48;
                if (row[i][val - 1] != 0) {
                    return false;
                } else {
                    row[i][val - 1] = 1;
                }
                // 列判断
                if (col[j][val - 1] != 0) {
                    return false;
                } else {
                    col[j][val - 1] = 1;
                }
                // 块判断
                int blockRow = i / 3;
                int blockCol = j / 3;
                if (block[blockRow * 3 + blockCol][val - 1] != 0) {
                    return false;
                } else {
                    block[blockRow * 3 + blockCol][val - 1] = 1;
                }
            }
        }
        return true;
    }
}
