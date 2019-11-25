package first.graph;

/**
 * @author wuping
 * @date 2019-07-10
 * https://leetcode.com/problems/find-the-town-judge/
 * N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 3
 */

public class FindJudge {
    public static void main(String[] args) {
        int[][] trust = new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println(new FindJudge().findJudge(4, trust));
    }

    public int findJudge(int N, int[][] trust) {
        if (trust == null) {
            return -1;
        }
        if (trust.length == 0 && N == 1) {
            return 1;
        }
        int[] indegree = new int[N];
        int[] outdegree = new int[N];
        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0] - 1]++;
            indegree[trust[i][1] - 1]++;
        }
        for (int i = 0; i < N; i++) {
            if (indegree[i] == N - 1 && outdegree[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
