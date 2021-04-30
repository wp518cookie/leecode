package likou.contest.contest_234;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2021-03-28
 * https://leetcode-cn.com/contest/weekly-contest-234/problems/maximize-number-of-nice-divisors/
 */

public class MaxNiceDivisors {
    private Map<Long, Long> mark = new HashMap();

    public static void main(String[] args) {
        System.out.println(new MaxNiceDivisors().maxNiceDivisors(98));
    }

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) {
            return 1;
        }
        return (int) recursion((long) primeFactors);
    }

    public long recursion(long t) {
        if (t == 0 || t == 1) {
            return 1;
        }
        if (mark.containsKey(t)) {
            return mark.get(t);
        }
        long result = t;
        for (int i = 2; i < t; i++) {
            result = Math.max(result, recursion(i) * recursion(t - i));
            if (result > 1000000007L) {
                result = result % 1000000007L;
            }
        }
        mark.put(t, result);
        return result;
    }
}
