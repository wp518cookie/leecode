package easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Climbing_Stairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }













































//    public static int climbStairs(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        int i = 3;
//        int[] count = new int[n];
//        count[0] = 1;
//        count[1] = 2;
//        while (i <= n) {
//            count[i-1] = count[i-3] + count[i-2];
//            i++;
//        }
//        return count[n - 1];
//    }
}
