package easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Valid_Perfect_Square_367 {
    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long result = mid * mid;
            if (result < num) {
                left = mid + 1;
            } else if (result > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        isPerfectSquare(2147483647);
    }
}
