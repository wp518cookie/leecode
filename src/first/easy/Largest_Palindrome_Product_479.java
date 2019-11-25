package first.easy;

/**
 * Created by ping.wu on 2017/2/16.
 */
public class Largest_Palindrome_Product_479 {
    public static void main(String[] args) {
        System.out.println(largestPalindrome(5));
    }

    public static int largestPalindrome(int n) {
        long a = 1;
        while (n-- > 0) {
            a = a * 10;
        }
        long sum = a * a - 1;
        long max = a - 1;
        long min = a * a / 100;
        while (sum > min) {
            if (judgePalindrome(sum)) {
                for (long i = max; i >= a / 10; i --) {
                    if (sum % i == 0 && (sum / i) < max) {
                        return (int)sum % 1337;
                    }
                }
            }
            sum--;
        }
        return 0;
    }

    public static boolean judgePalindrome(long n) {
        char[] temp = String.valueOf(n).toCharArray();
        int length = temp.length;
        for (int i = 0; i < length / 2; i++) {
            if (temp[i] != temp[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
