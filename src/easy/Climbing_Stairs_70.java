package easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i = 3;
        int[] count = new int[n];
        count[0] = 1;
        count[1] = 2;
        while (i <= n) {
            count[i-1] = count[i-3] + count[i-2];
            i++;
        }
        return count[n - 1];
    }
}
