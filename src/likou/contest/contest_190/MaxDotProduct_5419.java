package likou.contest.contest_190;

/**
 * @author wuping
 * @date 2020-05-24
 * https://leetcode-cn.com/contest/weekly-contest-190/problems/max-dot-product-of-two-subsequences/
 */

public class MaxDotProduct_5419 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{-3,-8,3,-10,1,3,9};
        int[] nums2 = new int[]{9,2,3,7,-9,1,-8,5,-1,-1};
        System.out.println(new MaxDotProduct_5419().maxDotProduct(nums1, nums2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int col = nums2.length;
        int row = nums1.length;
        int[][] mark = new int[row][col];
        for (int i = 0; i < col; i++) {
            mark[0][i] = nums1[0] * nums2[i];
            if (i != 0) {
                mark[0][i] = Math.max(mark[0][i - 1], mark[0][i]);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int t = nums1[i] * nums2[j];
                if (j == 0) {
                    mark[i][j] = t;
                } else {
                    mark[i][j] = Math.max(t, t + mark[i - 1][j - 1]);
                    mark[i][j] = Math.max(mark[i][j], mark[i][j - 1]);
                }
                mark[i][j] = Math.max(mark[i - 1][j], mark[i][j]);
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            result = Math.max(result, mark[row - 1][i]);
        }
        return result;
    }
}
