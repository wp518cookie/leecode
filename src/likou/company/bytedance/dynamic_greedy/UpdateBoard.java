package likou.company.bytedance.dynamic_greedy;

/**
 * @author wuping
 * @date 2020-08-20
 * https://leetcode-cn.com/problems/minesweeper/
 * 让我们一起来玩扫雷游戏！
 * <p>
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * <p>
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 * 示例 1：
 * <p>
 * 输入:
 * <p>
 * [['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'M', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E'],
 * ['E', 'E', 'E', 'E', 'E']]
 * <p>
 * Click : [3,0]
 * <p>
 * 输出:
 * <p>
 * [['B', '1', 'E', '1', 'B'],
 * ['B', '1', 'M', '1', 'B'],
 * ['B', '1', '1', '1', 'B'],
 * ['B', 'B', 'B', 'B', 'B']]
 */

public class UpdateBoard {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null) {
            return null;
        }
        int row = board.length;
        int col = board[0].length;
        char[][] result = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = board[i][j];
            }
        }
        recursion(board, result, click[0], click[1]);
        return result;
    }

    public void recursion(char[][] board, char[][] result, int rIdx, int cIdx) {
        if (rIdx >= board.length || rIdx < 0) {
            return;
        }
        if (cIdx >= board[0].length || cIdx < 0) {
            return;
        }
        if (result[rIdx][cIdx] != 'M' && result[rIdx][cIdx] != 'E') {
            return;
        }
        if (board[rIdx][cIdx] == 'M') {
            result[rIdx][cIdx] = 'X';
            return;
        }
        int count = count(board, rIdx, cIdx);
        if (count > 0) {
            result[rIdx][cIdx] = (char) (count + '0');
        } else {
            result[rIdx][cIdx] = 'B';
            recursion(board, result, rIdx, cIdx - 1);
            recursion(board, result, rIdx, cIdx + 1);
            recursion(board, result, rIdx - 1, cIdx);
            recursion(board, result, rIdx + 1, cIdx);
            recursion(board, result, rIdx - 1, cIdx - 1);
            recursion(board, result, rIdx + 1, cIdx + 1);
            recursion(board, result, rIdx + 1, cIdx - 1);
            recursion(board, result, rIdx - 1, cIdx + 1);
        }
    }

    public int count(char[][] board, int rIdx, int cIdx) {
        int count = 0;
        if (ifMine(board, rIdx - 1, cIdx)) {
            count++;
        }
        if (ifMine(board, rIdx - 1, cIdx - 1)) {
            count++;
        }
        if (ifMine(board, rIdx - 1, cIdx + 1)) {
            count++;
        }
        if (ifMine(board, rIdx, cIdx - 1)) {
            count++;
        }
        if (ifMine(board, rIdx, cIdx + 1)) {
            count++;
        }
        if (ifMine(board, rIdx + 1, cIdx)) {
            count++;
        }
        if (ifMine(board, rIdx + 1, cIdx - 1)) {
            count++;
        }
        if (ifMine(board, rIdx + 1, cIdx + 1)) {
            count++;
        }
        return count;
    }

    private boolean ifMine(char[][] board, int rIdx, int cIdx) {
        if (rIdx < 0 || rIdx >= board.length) {
            return false;
        }
        if (cIdx < 0 || cIdx >= board[0].length) {
            return false;
        }
        return board[rIdx][cIdx] == 'M';
    }
}
