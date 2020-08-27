package likou.contest.contest_200;

/**
 * @author wuping
 * @date 2020-08-02
 */

public class GetWinner {
    public int getWinner(int[] arr, int k) {
        if (k == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int length = arr.length;
        int count = 0;
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                count = 1;
            } else {
                count++;
                if (count == k) {
                    return max;
                }
            }
        }
        return max;
    }
}
