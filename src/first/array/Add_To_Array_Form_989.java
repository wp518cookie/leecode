package first.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-25
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */

public class Add_To_Array_Form_989 {
    public static void main(String[] args) {
        List<Integer> result = new Add_To_Array_Form_989().addToArrayForm(new int[]{2, 7, 4}, 181);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int idx = A.length - 1;
        boolean bitFlag = false;
        int sum;
        int t;
        List<Integer> result = new LinkedList<>();
        while (idx >= 0 && K > 0) {
            t = K % 10;
            K = K / 10;
            sum = A[idx--] + t + (bitFlag ? 1 : 0);
            if (sum >= 10) {
                sum = sum % 10;
                bitFlag = true;
            } else {
                bitFlag = false;
            }
            result.add(0, sum);
        }
        while (idx >= 0) {
            sum = A[idx--] + (bitFlag ? 1 : 0);
            if (sum >= 10) {
                sum = 0;
                bitFlag = true;
            } else {
                bitFlag = false;
            }
            result.add(0, sum);
        }
        while (K > 0) {
            t = K % 10;
            K = K / 10;
            sum = t + (bitFlag ? 1 : 0);
            if (sum >= 10) {
                sum = 0;
                bitFlag = true;
            } else {
                bitFlag = false;
            }
            result.add(0, sum);
        }
        if (bitFlag) {
            result.add(0, 1);
        }
        return result;
    }
}
