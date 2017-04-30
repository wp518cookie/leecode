package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Valid_Sudoku_36 {
    public static void main(String[] args) {

    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] col = new HashSet[9];
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] block = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char t = board[i][j];
                if (t == '.') {
                    continue;
                }
                if (row[i] == null) {
                    row[i] = new HashSet();
                }
                if (row[i].contains(t)) {
                    return false;
                } else {
                    row[i].add(t);
                }
                if (col[j] == null) {
                    col[j] = new HashSet();
                }
                if (col[j].contains(t)) {
                    return false;
                } else {
                    col[j].add(t);
                }
                if (block[(i/3) * 3 + j / 3] == null) {
                    block[(i/3) * 3 + j / 3] = new HashSet();
                }
                if (block[(i/3) * 3 + j / 3].contains(t)) {
                    return false;
                } else {
                    block[(i/3) * 3 + j / 3].add(t);
                }
            }
        }
        return true;
    }
}
