package likou.contest.contest_203;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-08-23
 * https://leetcode-cn.com/contest/weekly-contest-203/problems/most-visited-sector-in-a-circular-track/
 */

public class MostVisited {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MostVisited().mostVisited(4, new int[]{1, 3, 1, 2}).toArray()));
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n];
        for (int i = 0; i < rounds.length - 1; i++) {
            int t = rounds[i];
            int j = i == 0 ? t : t + 1;
            while (true) {
                if (j > n) {
                    j = 1;
                }
                count[j - 1]++;
                if (j == rounds[i + 1]) {
                    break;
                } else {
                    j++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        List<Integer> mark = new ArrayList();
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                mark.add(i + 1);
            } else if (max < count[i]) {
                max = count[i];
                mark = new ArrayList<>();
                mark.add(i + 1);
            }
        }
        return mark;
    }
}
