package likou.first_try.dynamic_programming;

/**
 * @author wuping
 * @date 2020-09-30
 * https://leetcode-cn.com/problems/partition-array-for-maximum-sum/
 * <p>
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
 * <p>
 * 返回给定数组完成分隔后的最大和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 */

public class MaxSumAfterPartitioning_1043 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 15, 7, 9, 2, 5, 10};
        System.out.println(new MaxSumAfterPartitioning_1043().maxSumAfterPartitioning(A, 3));
    }

    // dp

    //执行用时：
    //50 ms
    //, 在所有 Java 提交中击败了
    //10.38%
    //的用户
    //内存消耗：
    //38.3 MB
    //, 在所有 Java 提交中击败了
    //70.41%
    //的用户
    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length <= K) {
            return count(0, A.length - 1, A);
        }
        int[] dp = new int[A.length];
        for (int i = 0; i < K; i++) {
            dp[i] = count(0, i, A);
        }
        for (int i = K; i < A.length; i++) {
            int result = Integer.MIN_VALUE;
            for (int j = i; j > i - K; j--) {
                result = Math.max(result, dp[j - 1] + count(j, i, A));
            }
            dp[i] = result;
        }
        return dp[A.length - 1];
    }

    //递归
//    public int maxSumAfterPartitioning(int[] A, int K) {
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        if (A.length <= K) {
//            return count(0, A.length - 1, A);
//        }
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < K && i < A.length; i++) {
//            result = Math.max(result, count(0, i, A) + recursion(i + 1, A, K));
//        }
//        return result;
//    }
//
//    public int recursion(int start, int[] A, int K) {
//        if (start >= A.length) {
//            return 0;
//        }
//        if (start == A.length - 1) {
//            return A[start];
//        }
//        int result = Integer.MIN_VALUE;
//        for (int i = start; i < A.length && i < start + K; i++) {
//            result = Math.max(result, count(start, i, A) + recursion(i + 1, A, K));
//        }
//        return result;
//    }

    public int count(int from, int to, int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = from; i <= to; i++) {
            max = Math.max(max, A[i]);
        }
        return max * (to - from + 1);
    }
}
