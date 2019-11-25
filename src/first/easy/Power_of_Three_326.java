package first.easy;

/**
 * Created by ping.wu on 2017/1/19.
 */
public class Power_of_Three_326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2));
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
