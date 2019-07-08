package geekbang.tanchao.dp;

/**
 * @author wuping
 * @date 2019-07-03
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */

public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{2, -1, 1, 1};
        System.out.println(maxProduct.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxLocal = new int[nums.length];
        int[] minLocal = new int[nums.length];
        maxLocal[0] = nums[0];
        minLocal[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            if (val > 0) {
                maxLocal[i] = Math.max(maxLocal[i - 1] * val, val);
                minLocal[i] = Math.min(minLocal[i - 1] * val, val);
            } else if (val < 0) {
                maxLocal[i] = Math.max(Math.max(maxLocal[i - 1] * val, val), minLocal[i - 1] * val);
                minLocal[i] = Math.min(Math.min(minLocal[i - 1] * val, val), maxLocal[i - 1] * val);
            } else {
                maxLocal[i] = 0;
                minLocal[i] = 0;
            }
            if (max < maxLocal[i]) {
                max = maxLocal[i];
            }
        }
        return max;
    }
}
