package first.easy;

/**
 * Created by ping.wu on 2016/11/16.
 */
public class Sum_of_Two_Integers_371 {
    public static void main(String[] args) {
        System.out.println(getSum(-1, 2));
    }

    public static int getSum(int a, int b) {
        int c = a ^ b;
        int d = a & b;
        while (d != 0) {
            d = d << 1;
            int temp = c;
            c = c ^ d;
            d = d & temp;
        }
        return c;
    }
}
