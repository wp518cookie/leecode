package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-08
 * https://leetcode-cn.com/problems/game-of-life/
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 *
 */

public class GameOfLife_289 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1}, {1, 0}};
        new GameOfLife_289().gameOfLife(arr);
    }

    public void gameOfLife(int[][] board) {
        if (board == null) {
            return;
        }
        int row = board.length;
        if (row == 0) {
            return;
        }
        int col = board[0].length;
        if (col == 0) {
            return;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int alive = count(board, i, j, row, col);
                if (alive < 2 && board[i][j] == 1) {
                    board[i][j] = 3;
                }
                if (alive == 3) {
                    if (board[i][j] == 0) {
                        board[i][j] = 2;
                    }
                }
                if (alive > 3) {
                    if (board[i][j] == 1) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int t = board[i][j];
                if (t == 2) {
                    board[i][j] = 1;
                } else if (t == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public int count(int[][] board, int i, int j, int row, int col) {
        int count = 0;
        if (i > 0) {
            if (board[i - 1][j] == 1 || board[i - 1][j] == 3) {
                count++;
            }
            if (j > 0) {
                if (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 3) {
                    count++;
                }
            }
            if (j < col - 1) {
                if (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 3) {
                    count++;
                }
            }
        }
        if (j > 0) {
            if (board[i][j - 1] == 1 || board[i][j - 1] == 3) {
                count++;
            }
        }
        if (j < col - 1) {
            if (board[i][j + 1] == 1 || board[i][j + 1] == 3) {
                count++;
            }
        }
        if (i < row - 1) {
            if (board[i + 1][j] == 1 || board[i + 1][j] == 3) {
                count++;
            }
            if (j > 0) {
                if (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 3) {
                    count++;
                }
            }
            if (j < col - 1) {
                if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 3) {
                    count++;
                }
            }
        }
        return count;
    }
}
