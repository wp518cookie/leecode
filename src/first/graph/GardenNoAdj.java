package first.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-10
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 * Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * Output: [1,2,3,4]
 */

public class GardenNoAdj {
    public static void main(String[] args) {

    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        HashSet<Integer>[] marks = new HashSet[N];
        for (int i = 0; i < N; i++) {
            marks[i] = new HashSet();
        }
        for (int i = 0; i < paths.length; i++) {
            int idx1 = paths[i][0];
            int idx2 = paths[i][1];
            marks[idx1 - 1].add(idx2 - 1);
            marks[idx2 - 1].add(idx1 - 1);
        }
        int[] flowers = new int[N];
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = -1;
        }
        for (int i = 0; i < N; i++) {
            Set<Integer> set = marks[i];
            for (int j = 0; j < 4; j++) {
                boolean flag = true;
                for (int v : set) {
                    if (flowers[v] == j + 1) {
                        flag = false;
                    }
                }
                if (flag) {
                    flowers[i] = j + 1;
                    break;
                }
            }
        }
        return flowers;
    }

    public void recursion(int[] floweres, HashSet<Integer>[] marks, int i, int N) {

    }
}
