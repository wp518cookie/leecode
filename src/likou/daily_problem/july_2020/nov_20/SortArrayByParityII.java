package likou.daily_problem.july_2020.nov_20;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2020-11-12
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * <p>
 * <p>
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * 提示：
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(arr)));
    }

    public int[] sortArrayByParityII(int[] A) {
        int oddIdx = 1;
        int evenIdx = 0;
        int[] result = new int[A.length];
        while (oddIdx < A.length) {
            while (A[oddIdx] % 2 == 1) {
                result[oddIdx] = A[oddIdx];
                oddIdx += 2;
            }
            while (A[evenIdx] % 2 == 0) {
                result[evenIdx] = A[evenIdx];
                evenIdx += 2;
            }
            result[evenIdx] = A[oddIdx];
            result[oddIdx] = A[evenIdx];
            oddIdx += 2;
            evenIdx += 2;
        }
        return result;
    }
}
