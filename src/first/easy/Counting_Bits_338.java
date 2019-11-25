package first.easy;

/**
 * Created by ping.wu on 2016/11/17.
 */
public class Counting_Bits_338 {
    public static void main(String[] args) {
        int[] re = countBits1(3);
        for (int i : re) {
            System.out.println(i);
        }
    }

    public static int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num ; i++) {
            if (i <= 2) {
                result[i] = i/2 + i%2;
            } else {
                int temp = i%2;
                result[i] = result[i>>1] + temp;
            }
        }
        return result;
    }
}
