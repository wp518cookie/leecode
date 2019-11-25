package first.array;

/**
 * @author wuping
 * @date 2019-07-18
 */

public class Fibonacci_Number_509 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        return fib(N - 1) + fib(N -2);
    }
}
