package geekbang.tanchao.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-08
 * [[1,0,0,1],
 *  [0,1,1,0],
 *  [0,1,1,1],
 *  [1,0,1,1]]
 *
 *  1
 */

public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        if (M.length <= 0 || M[0].length <=0) {
            return 0;
        }
        int rowLength = M.length;
        int colLength = M[0].length;
        boolean[][] mark = new boolean[rowLength][colLength];
        int count = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (M[i][j] == 1 && !mark[i][j]) {
                    breadthFirstSearch(i, mark, M);
                    count++;
                }
            }
        }
        return count;
    }

    private void breadthFirstSearch(int i, boolean[][] mark, int[][] M) {
        mark[i][i] = true;
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !mark[i][j]) {
                mark[i][j] = true;
                breadthFirstSearch(j, mark, M);
            }
        }
    }
}
