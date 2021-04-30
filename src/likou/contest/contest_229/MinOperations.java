package likou.contest.contest_229;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2021-02-21
 * https://leetcode-cn.com/contest/weekly-contest-229/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */

public class MinOperations {
    public static void main(String[] args) {
        String boxes = "1";
        System.out.println(Arrays.toString(new MinOperations().minOperations(boxes)));
    }

    public int[] minOperations(String boxes) {
        int left = 0;
        int leftCount = 0;
        int right = 0;
        int rightCount = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                rightCount += i;
            }
        }
        int[] result = new int[boxes.length()];
        result[0] = rightCount;
        for (int i = 1; i < boxes.length(); i++) {
            leftCount = leftCount + left;
            if (boxes.charAt(i - 1) == '1') {
                left++;
                leftCount = leftCount + 1;
            }
            if (boxes.charAt(i) == '1') {
                right--;
                rightCount--;
            }
            rightCount = rightCount - right;
            result[i] = leftCount + rightCount;
        }
        return result;
    }
}
