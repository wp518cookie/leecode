package geekbang.wangzheng.dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-12
 */

public class ChessBoard {
    private int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] chessBoard = new int[4][4];
        chessBoard[0] = new int[]{1, 3, 5, 9};
        chessBoard[1] = new int[]{2, 1, 3, 4};
        chessBoard[2] = new int[]{5, 2, 6, 7};
        chessBoard[3] = new int[]{6, 8, 4, 3};
        System.out.println(new ChessBoard().dp(chessBoard));
    }

    public int minStep(int[][] chessBoard) {
        recursion(chessBoard, 0, 0, 0);
        return min;
    }

    public void recursion(int[][] board, int rowIdx, int colIdx, int currentStep) {
        if (rowIdx == board.length - 1 && colIdx == board.length - 1) {
            if (currentStep + board[board.length - 1][board.length - 1] < min) {
                min = currentStep + board[board.length - 1][board.length - 1];
            }
        }
        currentStep = currentStep + board[rowIdx][colIdx];
        if (rowIdx < board.length - 1) {
            recursion(board, rowIdx + 1, colIdx, currentStep);
        }
        if (colIdx < board.length - 1) {
            recursion(board, rowIdx, colIdx + 1, currentStep);
        }
    }

    public int dp(int[][] board) {
        int length = board.length;
        int[][] states = new int[length][length];
        states[0][0] = board[0][0];
        for (int i = 1; i < length; i++) {
            states[0][i] = states[0][i - 1] + board[0][i];
            states[i][0] = states[i - 1][0] + board[i][0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                states[i][j] = Math.min(states[i - 1][j], states[i][j - 1]) + board[i][j];
            }
        }
        return states[length - 1][length - 1];
    }
}
