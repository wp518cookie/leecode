package likou.contest.contest_186;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-04-26
 * https://leetcode-cn.com/contest/weekly-contest-186/problems/maximum-points-you-can-obtain-from-cards/
 */

public class maxScore_5393 {
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap();

    public static void main(String[] args) {
        int[] t = new int[]{1};
        System.out.println(new maxScore_5393().maxScore(t, 3));
    }

//    public int maxScore(int[] cardPoints, int k) {
//        return recursion(cardPoints, 0, cardPoints.length - 1, k);
//    }
//
//    public int recursion(int[] cardPoints, int start, int end, int k) {
//        Pair<Integer, Integer> pair = new Pair<>(start, end);
//        if (memo.containsKey(pair)) {
//            return memo.get(pair);
//        }
//        if (k == 0) {
//            return 0;
//        }
//        if (start == end) {
//            return cardPoints[start];
//        }
//        int result = Math.max(cardPoints[start] + recursion(cardPoints, start + 1, end, k - 1), cardPoints[end] + recursion(cardPoints, start, end - 1, k - 1));
//        memo.put(pair, result);
//        return result;
//    }

    public int maxScore(int[] cardPoints, int k) {
        int headCount = 0;
        int lastCount = 0;
        int length = cardPoints.length;
        for (int i = 0; i < k ; i++) {
            headCount += cardPoints[i];
        }
        if (k == length) {
            return headCount;
        }
        int maxCount = headCount;
        for (int i = k - 1; i >= 0; i--) {
            headCount -= cardPoints[i];
            lastCount += cardPoints[length - k + i];
            maxCount = Math.max(maxCount, headCount + lastCount);
        }
        return maxCount;
    }
}
