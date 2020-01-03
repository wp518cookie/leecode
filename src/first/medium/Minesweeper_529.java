package first.medium;

/**
 * @author wuping
 * @date 2019-12-31
 *
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。

 *
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 *
 *
[['B', '1', 'E', '1', 'B'],
['B', '1', 'M', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]


Input:

[['B', '1', 'E', '1', 'B'],
['B', '1', 'M', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

Output:

[['B', '1', 'E', '1', 'B'],
['B', '1', 'X', '1', 'B'],
['B', '1', '1', '1', 'B'],
['B', 'B', 'B', 'B', 'B']]
 */














public class Minesweeper_529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        int row = board.length;
        int col = board[0].length;
        int count = count(x, y, board, row, col);
        if (count != 0) {
            board[x][y] = (char)(count + 48);
            return board;
        }
        board[x][y] = 'B';
        recursion(x, y, board, row, col);
        return board;
    }

    private void updateBoard(char[][] board, int x, int y, int row, int col) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (board[x][y] != 'E') {
            return;
        }
        int count = count(x, y, board, row, col);
        if (count != 0) {
            board[x][y] = (char)(count + 48);
            return;
        }
        board[x][y] = 'B';
        recursion(x, y, board, row, col);
    }

    private void recursion(int x, int y, char[][] board, int row, int col) {
        updateBoard(board, x - 1, y, row, col);
        updateBoard(board, x - 1, y - 1, row, col);
        updateBoard(board, x - 1, y + 1, row, col);
        updateBoard(board, x, y - 1, row, col);
        updateBoard(board, x, y + 1, row, col);
        updateBoard(board, x + 1, y - 1, row, col);
        updateBoard(board, x + 1, y, row, col);
        updateBoard(board, x + 1, y + 1, row, col);
    }

    private int count(int x, int y, char[][] board, int row, int col) {
        int count = 0;
        if (x > 0) {
            if (board[x - 1][y] == 'M') {
                count++;
            }
            if (y > 0) {
                if (board[x - 1][y - 1] == 'M') {
                    count++;
                }
            }
            if (y < col - 1) {
                if (board[x - 1][y + 1] == 'M') {
                    count++;
                }
            }
        }
        if (y > 0) {
            if (board[x][y - 1] == 'M') {
                count++;
            }
        }
        if (y < col - 1) {
            if (board[x][y + 1] == 'M') {
                count++;
            }
        }
        if (x < row - 1) {
            if (board[x + 1][y] == 'M') {
                count++;
            }
            if (y > 0) {
                if (board[x + 1][y - 1] == 'M') {
                    count++;
                }
            }
            if (y < col - 1) {
                if (board[x + 1][y + 1] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
