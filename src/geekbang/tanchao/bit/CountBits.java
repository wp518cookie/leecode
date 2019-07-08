package geekbang.tanchao.bit;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-03
 * https://leetcode.com/problems/counting-bits/
 */

public class CountBits {
    public static void main(String[] args) {
        int n = 8;
        CountBits countBits = new CountBits();
        System.out.println(Arrays.toString(countBits.countBits(n)));
    }

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num == 0) {
            result[0] = 0;
            return result;
        }
        if (num == 1) {
            result[0] = 0;
            result[1] = 1;
            return result;
        }
        result[0] = 0;
        result[1] = 1;
        int cycle = 2;
        int t = 0;
        for (int i = 2; i <= num; i++) {
            if (t == cycle) {
                cycle = i;
                t = 0;
            }
            result[i] = 1 + result[t];
            t++;

        }
        return result;
    }
}
