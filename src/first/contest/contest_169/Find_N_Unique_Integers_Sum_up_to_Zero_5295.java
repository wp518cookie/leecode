package first.contest.contest_169;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-12-29
 */

public class Find_N_Unique_Integers_Sum_up_to_Zero_5295 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Find_N_Unique_Integers_Sum_up_to_Zero_5295().sumZero(5)));
    }
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n % 2 == 0) {
            int count = 0;
            for (int i = n / 2; i > 0; i--) {
                result[count++] = i;
                result[count++] = -i;
            }
        } else {
            int count = 0;
            for (int i = n / 2; i > 0; i--) {
                result[count++] = i;
                result[count++] = -i;
            }
            result[count] = 0;
        }
        return result;
    }
}
