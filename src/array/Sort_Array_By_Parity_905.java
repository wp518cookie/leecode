package array;

/**
 * @author wuping
 * @date 2019-07-16
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */

public class Sort_Array_By_Parity_905 {
    public int[] sortArrayByParity(int[] A) {
        int head = 0;
        int end = A.length - 1;
        while (head < end) {
            if (A[head] % 2 == 0) {
                head++;
                continue;
            }
            int temp = A[end];
            A[end] = A[head];
            A[head] = temp;
            end--;
        }
        return A;
    }
}
