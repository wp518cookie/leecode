package first.bit;

/**
 * @author wuping
 * @date 2019-09-06
 * https://leetcode.com/problems/reverse-bits/
 */

public class Reverse_Bits_190 {
    public static void main(String[] args) {
        String s = "00000010100101000001111010011100";
        Integer t = Integer.parseInt(s, 2);
        System.out.println(t);
        System.out.println(reverseBits(t));
    }
    public static int reverseBits(int n) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            if (n == 0) {
                break;
            }
            if ((n & 1) != 0) {
                bits[i] = 1;
            }
            n = n >> 1;
        }
        int t = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] == 1) {
                t = t | 1 << (31 - i);
            }
        }
        return t;
    }
}
