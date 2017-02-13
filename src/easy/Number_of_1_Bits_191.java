package easy;

/**
 * Created by ping.wu on 2017/2/9.
 */
public class Number_of_1_Bits_191 {
//    2147483648 (10000000000000000000000000000000)
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n / 2;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(hammingWeight(2147483648));
    }
}
