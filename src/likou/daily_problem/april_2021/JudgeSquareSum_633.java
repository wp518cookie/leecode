package likou.daily_problem.april_2021;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuping
 * @date 2021-04-28
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 *
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 *
 * 提示：
 * 0 <= c <= 231 - 1
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 */

public class JudgeSquareSum_633 {
    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum_633().judgeSquareSum(5));
    }

    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i <= c; i++) {
            if (findSqrt(i) >= 0) {
                set.add(i);
            } else {
                continue;
            }
            if (set.contains(c - i)) {
                return true;
            }
        }
        return false;
    }

    public int findSqrt(long t) {
        if (t == 0) {
            return 0;
        }
        long start = 0;
        long end = t;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long val = mid * mid;
            if (val > t) {
                end = mid - 1;
                continue;
            } else if (val < t) {
                start = mid + 1;
                continue;
            } else {
                return (int) mid;
            }
        }
        return -1;
    }
}
