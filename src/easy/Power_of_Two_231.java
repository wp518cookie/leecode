package easy;

/**
 * Created by ping.wu on 2017/1/19.
 */
public class Power_of_Two_231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(15));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (Integer.highestOneBit(n) ^ n) == 0 ? true : false;
    }
}
