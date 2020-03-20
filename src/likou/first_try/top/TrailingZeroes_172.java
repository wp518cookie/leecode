package likou.first_try.top;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-03-10
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */

public class TrailingZeroes_172 {
    public static void main(String[] args) {
        System.out.println(new TrailingZeroes_172().trailingZeroes(100));
    }

    /**
     * 超时
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> cache = new HashMap();
        for (int i = 1; i <= n; i++) {
            int t = i;
            if (t % 5 == 0) {
                int count = 1;
                t = t / 5;
                while (t > 0) {
                    if (cache.get(t) != null) {
                        count = count + cache.get(t);
                        break;
                    } else {
                        break;
                    }
                }
                cache.put(i, count);
                result += count;
            }
        }
        return result;
    }

    public int trailingZeroes1(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
