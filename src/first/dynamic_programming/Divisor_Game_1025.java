package first.dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-11
 * https://leetcode.com/problems/divisor-game/
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 */

public class Divisor_Game_1025 {
    public static void main(String[] args) {
        System.out.println(new Divisor_Game_1025().divisorGame(2));
    }

    public boolean divisorGame(int N) {
        if (N < 2) {
            return false;
        }
        int[] mark = new int[N + 1];
        mark[0] = -1;
        mark[1] = -1;
        for (int i = 2; i <= N; i++) {
            mark[i] = -1;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    if (mark[i - j] == -1) {
                        mark[i] = 1;
                        break;
                    }
                }
            }
        }
        return mark[N] == 1;
    }
}
