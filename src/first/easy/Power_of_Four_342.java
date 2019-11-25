package first.easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Power_of_Four_342 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(8));

    }

    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == Integer.highestOneBit(num)) {
            String result = Integer.toBinaryString(num);
            if (result.length() % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}
