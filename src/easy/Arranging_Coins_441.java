package easy;

/**
 * Created by Administrator on 2017/12/21.
 */
public class Arranging_Coins_441 {
    public static void main(String[] args) {
        System.out.println(solution2(6));
    }

    public static int arrangeCoins(int n) {
        int step = 1;
        while (n >= step) {
            n -= step;
            step++;
        }
        return step - 1;
    }

    public static int solution2(int n) {
        // 利用等差数列求和公式求值
        return (int)((-1 + (Math.sqrt(1 + 8 * (long)n))) / 2);
    }
}
