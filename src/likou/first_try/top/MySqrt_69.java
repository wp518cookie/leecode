package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-06
 *
 * https://leetcode-cn.com/problems/sqrtx/
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *
 * error:
 * 2147395599
 * 484691782
 * 46339
 */

public class MySqrt_69 {
    public static void main(String[] args) {
        int max = (1 << 30) - 1;
//        System.out.println(new MySqrt_69().mySqrt(2147395599));
        System.out.println(Integer.MAX_VALUE);
    }

//    执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
//    内存消耗 :37.3 MB, 在所有 Java 提交中击败了5.06%的用户
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        long start = 0;
        long end = x;
        while(start < end) {
            long mid = start + ((end - start + 1) >> 1);
            long result = mid * mid;
            if (result > x) {
                end = mid - 1;
            } else if (result < x) {
                start = mid;
            } else {
                return (int) mid;
            }
        }
        return (int)start;
    }
}
