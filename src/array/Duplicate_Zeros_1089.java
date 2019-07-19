package array;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2019-07-19
 * https://leetcode.com/problems/duplicate-zeros/
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */

public class Duplicate_Zeros_1089 {
    public static void main(String[] args) {
        new Duplicate_Zeros_1089().duplicateZeros(new int[]{0, 0, 0, 0, 0, 0});
    }

    public void duplicateZeros(int[] arr) {
        int count = 0;
        int finalIdx = arr.length - 1;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count += 2;
            } else {
                count++;
            }
            if (count >= arr.length) {
                if (count > arr.length) {
                    flag = false;
                }
                finalIdx = i;
                break;
            }
        }
        int currIdx = arr.length - 1;
        if (arr[finalIdx] == 0) {
            arr[currIdx--] = 0;
            if (flag) {
                arr[currIdx--] = 0;
            }
        } else {
            arr[currIdx--] = arr[finalIdx];
        }
        for (int i = finalIdx - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[currIdx--] = 0;
                arr[currIdx--] = 0;
            } else {
                arr[currIdx--] = arr[i];
            }
        }
    }
}
