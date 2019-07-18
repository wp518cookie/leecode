package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-07-18
 * https://leetcode.com/problems/relative-sort-array/
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */

public class Relative_Sort_Array_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        int[] result = new int[arr1.length];
        for (int i : arr1) {
            temp[i]++;
        }
        int idx = 0;
        for (int t : arr2) {
            while (temp[t] > 0) {
                result[idx++] = t;
                temp[t]--;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                result[idx++] = i;
                temp[i]--;
            }
        }
        return result;
    }
}
