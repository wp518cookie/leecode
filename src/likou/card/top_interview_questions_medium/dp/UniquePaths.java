package likou.card.top_interview_questions_medium.dp;

/**
 * @author wuping
 * @date 2020-09-02
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvjigd/
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 2));
    }

    /**
     * todo 可优化
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] mark = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i > 0) {
                    count += mark[i - 1][j];
                }
                if (j > 0) {
                    count += mark[i][j - 1];
                }
                count = (count == 0) ? 1 : count;
                mark[i][j] = count;
            }
        }
        return mark[m - 1][n - 1];
    }
}
