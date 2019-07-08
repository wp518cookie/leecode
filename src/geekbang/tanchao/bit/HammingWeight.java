package geekbang.tanchao.bit;

/**
 * @author wuping
 * @date 2019-07-03
 * https://leetcode.com/problems/number-of-1-bits/
 */

public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(Integer.MAX_VALUE));
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
