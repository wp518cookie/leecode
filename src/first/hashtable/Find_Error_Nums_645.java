package first.hashtable;

/**
 * @author wuping
 * @date 2019-07-26
 */

public class Find_Error_Nums_645 {
    public int[] findErrorNums(int[] nums) {
        boolean[] mark = new boolean[10001];
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (mark[nums[i]]) {
                result[0] = nums[i];
            } else {
                mark[nums[i]] = true;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!mark[i]) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
