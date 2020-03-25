package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-25
 * https://leetcode-cn.com/problems/plus-one/
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int last = digits[digits.length - 1];
        if (last + 1 < 10) {
            digits[digits.length - 1] = last + 1;
            return digits;
        }
        int bit = 1;
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            int t = digits[i] + 1;
            if (t == 10) {
                bit = 1;
                digits[i] = 0;
            } else {
                digits[i] = t;
                return digits;
            }
        }
        if (bit == 1) {
            int[] result = new int[digits.length + 1];
            for (int i = 1; i < digits.length + 1; i++) {
                result[i] = digits[i - 1];
            }
            result[0] = 1;
            return result;
        }
        return digits;
    }
}
