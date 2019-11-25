package first.array;

/**
 * @author wuping
 * @date 2019-07-18
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */

public class Sum_Even_After_Queries_985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];
            int oldVal = A[idx];
            A[idx] = oldVal + val;
            if (i == 0) {
                int sum = 0;
                for (int t : A) {
                    if (t % 2 == 0) {
                        sum += t;
                    }
                }
                result[i] = sum;
            } else {
                result[i] = result[i - 1];
                if (oldVal % 2 == 0) {
                    result[i] -= oldVal;
                }
                if (A[idx] % 2 == 0) {
                    result[i] += A[idx];
                }
            }
        }
        return result;
    }
}
