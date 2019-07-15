package other;

/**
 * @author wuping
 * @date 2019-07-12
 * {1， 3， -2， 4， -5}
 */

public class MaxSequence {
    public static void main(String[] args) {
        System.out.println(new MaxSequence().maxsequence(new int[]{1,3,-2,4,-5}, 5));
    }
    public int maxsequence(int arr[], int len) {
        int max = arr[0];
        int[] greed = new int[len];
        greed[0] = arr[0];
        for (int i = 1; i < len; i++) {
            greed[i] = Math.max(greed[i - 1] + arr[i], arr[i]);
            max = Math.max(max, greed[i]);
        }
        return max;
    }
}
