package geekbang.tanchao.recursion_and_separate;

/**
 * @author wuping
 * @date 2019-05-29
 */

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    public static double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        } else if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1;
        double temp = x;
        while (true) {
            if (n == 1) {
                return result * temp;
            }
            if (n % 2 == 0) {
                temp = temp * temp;
                n = n / 2;
            } else {
                result = result * temp;
                n--;
            }
        }
    }

    public double myPow1(double x, int n) {
        if( n == 0) {
            return 1;
        }

        double temp = myPow1(x, n/2);

        if (n % 2 == 0) {
            return temp*temp;
        } else {
            return n > 0 ? temp * temp * x : temp * temp * (1/x);
        }
    }
}
