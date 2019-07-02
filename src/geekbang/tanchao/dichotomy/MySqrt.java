package geekbang.tanchao.dichotomy;

/**
 * @author wuping
 * @date 2019-07-02
 * https://leetcode.com/problems/sqrtx/submissions/
 */

public class MySqrt {
    public static void main(String[] args) {
        int x = 100;
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        while (start < end) {
            long mid = start + ((end - start) >> 1);
            long val = mid * mid;
            if (val < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int)mid;
                } else {
                    start = mid + 1;
                }
            } else if (val > x) {
                end = mid - 1;
            } else {
                return (int)mid;
            }
        }
        return (int)start;
    }
}
