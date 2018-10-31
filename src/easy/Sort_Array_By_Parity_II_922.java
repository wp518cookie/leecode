package easy;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2018/10/31
 */
public class Sort_Array_By_Parity_II_922 {
    public static void main(String[] args) {
        int[] A = new int[]{4,2,5,7};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }

    public static int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 0;
        int[] arr = new int[A.length];
        int i = 0;
        while (true) {
            while (even < A.length) {
                if (A[even] % 2 == 0) {
                    break;
                }
                even++;
            }
            while (odd < A.length) {
                if (A[odd] % 2 != 0) {
                    break;
                }
                odd++;
            }
            if (even >= A.length || odd >= A.length) {
                break;
            }
            arr[i++] = A[even];
            arr[i++] = A[odd];
            even++;
            odd++;
        }
        return arr;
    }
}
