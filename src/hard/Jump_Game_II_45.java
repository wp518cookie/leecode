package hard;

/**
 * Created by Administrator on 2018/3/9.
 */
public class Jump_Game_II_45 {
    public static void main(String[] args) {
        int[] A = {2, 100, 1, 1, 4};
        System.out.println(jump(A));
    }

    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
