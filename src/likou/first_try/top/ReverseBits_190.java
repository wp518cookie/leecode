package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-02
 * https://leetcode-cn.com/problems/reverse-bits/
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 */

public class ReverseBits_190 {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                result = result | 1;
            }
            if (i != 0) {
                result = result << 1;
            }
        }
        int gap = 32 - s.length();
        while (gap-- > 0) {
            result = result << 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        int result = new ReverseBits_190().reverseBits(1);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(result));
    }
}