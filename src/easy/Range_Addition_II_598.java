package easy;
/**
 * Created by Administrator on 2017/10/17.
 */
public class Range_Addition_II_598 {
    public static void main(String[] args) {
        System.out.println(maxCount(3, 3, new int[][]{{2,2},{3,3}}));
    }

    public static int maxCount(int m, int n, int[][] ops) {
        int length = ops.length;
        if (length == 0) {
            return m * n;
        } else {
            int x = m;
            int y = n;
            for (int[] op : ops) {
                x = Math.min(x, op[0]);
                y = Math.min(y, op[1]);
            }
            return x * y;
        }
    }
}
