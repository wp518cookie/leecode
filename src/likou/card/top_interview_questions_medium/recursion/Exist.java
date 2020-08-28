package likou.card.top_interview_questions_medium.recursion;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvkwe2/
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 */

public class Exist {
    private boolean flag = false;
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] mark = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                recursion(board, i, j, mark, 0, word);
            }
        }
        return flag;
    }

    private void recursion(char[][] board, int i, int j, boolean[][] mark, int start, String word) {
        if (flag) {
            return;
        }
        if (start >= word.length()) {
            flag = true;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (mark[i][j]) {
            return;
        }
        char t = word.charAt(start);
        if (board[i][j] != t) {
            return;
        }
        mark[i][j] = true;
        recursion(board, i - 1, j, mark, start + 1, word);
        recursion(board, i + 1, j, mark, start + 1, word);
        recursion(board, i, j - 1, mark, start + 1, word);
        recursion(board, i, j + 1, mark, start + 1, word);
        mark[i][j] = false;
    }
}
