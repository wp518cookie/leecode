package easy;

/**
 * Created by ping.wu on 2016/12/28.
 */
public class Hamming_Distance_461 {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x, y));
    }

    public static int hammingDistance(int x, int y) {
        int count = 0;
        while (x != 0 || y != 0) {
            if (x % 2 !=  y % 2) {
                count++;
            }
            x = x>>1;
            y = y>>1;
        }
        return count;
    }
}
