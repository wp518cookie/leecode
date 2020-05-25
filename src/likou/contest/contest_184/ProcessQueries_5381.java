package likou.contest.contest_184;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-04-12
 */

public class ProcessQueries_5381 {
    public static void main(String[] args) {
        int[] t = new int[]{3,1,2,1};
        System.out.println(Arrays.toString(new ProcessQueries_5381().processQueries(t, 5)));
    }

    public int[] processQueries(int[] queries, int m) {
        int[] p = new int[m + 1];
        for (int i = 0; i < m; i++) {
            p[i + 1] = i;
        }
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            result[i] = p[idx];
            if (p[idx] == 0) {
                continue;
            } else {
                for (int j = 1; j <= m; j++) {
                    if (p[j] < p[idx]) {
                        p[j]++;
                    }
                }
                p[idx] = 0;
            }
        }
        return result;
    }
}
