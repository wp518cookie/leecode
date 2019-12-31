package first.hard;

/**
 * @author wuping
 * @date 2019-12-24
 */

public class Dungeon_Game_174 {
    private int min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(new Dungeon_Game_174().calculateMinimumHP(arr));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        Integer[][] newTable = new Integer[row][col];
        newTable[0][0] = dungeon[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i > 0) {
                    if (newTable[i][j] == null) {
                        newTable[i][j] = dungeon[i][j] + newTable[i - 1][j];
                    } else {
                        newTable[i][j] = Math.max(dungeon[i][j] + newTable[i - 1][j], newTable[i][j]);
                    }
                }
                if (j > 0) {
                    if (newTable[i][j] == null) {
                        newTable[i][j] = dungeon[i][j] + newTable[i][j - 1];
                    } else {
                        newTable[i][j] = Math.max(dungeon[i][j] + newTable[i][j - 1], newTable[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = row - 1; i >= 0; i++) {
            for (int j = col - 1; j >= 0; j++) {

            }
        }
        return 0;
    }
}
