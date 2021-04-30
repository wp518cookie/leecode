package likou.contest.contest_229;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2021-02-21
 * https://leetcode-cn.com/contest/weekly-contest-229/problems/maximum-score-from-performing-multiplication-operations/
 */

public class MaximumScore {

    private Map<Pair<Integer, Integer>, Integer> mark = new HashMap();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] m = {-5,-3,-3,-2,7,1};
        int[] n = {-10,-5,3,4,6};
        System.out.println(new MaximumScore().maximumScore(m, n));
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "");
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        if (multipliers.length == 1) {
            return Math.max(nums[0] * multipliers[0], nums[nums.length - 1] * multipliers[0]);
        }
        return Math.max(maximumScore(nums, multipliers, nums[0] * multipliers[0], 1, nums.length - 1, 1),
                maximumScore(nums, multipliers, nums[nums.length - 1] * multipliers[0], 0, nums.length - 2, 1));
    }

    public int maximumScore(int[] nums, int[] multipliers, int cur, int start, int end, int m) {
        Pair<Integer, Integer> pair = new Pair<>(start, end);
        if (mark.containsKey(pair)) {
            return cur + mark.get(pair);
        }
        if (m >= multipliers.length) {
            return cur;
        }
        int result = Math.max(maximumScore(nums, multipliers, nums[start] * multipliers[m], start + 1, end, m + 1),
                maximumScore(nums, multipliers, nums[end] * multipliers[m], start, end - 1, m + 1));
        mark.put(pair, result);
        return cur + result;
    }
}
