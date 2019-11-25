package first.bit;

/**
 * @author wuping
 * @date 2019-09-06
 * https://leetcode.com/problems/single-number-iii/
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 */

public class Single_Number_III_260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff = Integer.highestOneBit(diff);
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 0;
        for (int num : nums) {
            if ((diff & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
