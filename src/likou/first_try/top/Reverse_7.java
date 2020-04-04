package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-04
 * https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 */

public class Reverse_7 {
    public static void main(String[] args) {
        new Reverse_7().reverse(-123);
    }
    public int reverse(int x) {
        long result = 0;
        long temp = (long) x;
        boolean flag = temp < 0;
        if (flag) {
            temp = -temp;
        }
        while (temp > 0) {
            result = result * 10;
            long t = temp % 10;
            temp = temp / 10;
            result = result + t;
        }
        if (flag) {
            if (result - 1 > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) (-result);
        } else {
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) result;
        }
    }
}
