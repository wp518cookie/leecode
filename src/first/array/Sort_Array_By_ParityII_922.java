package first.array;

/**
 * @author wuping
 * @date 2019-07-18
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */

public class Sort_Array_By_ParityII_922 {
    public int[] sortArrayByParityII(int[] A) {
        int oddIdx = 1;
        int evenIdx = 0;
        while (true) {
            if (oddIdx >= A.length) {
                break;
            }
            while (A[oddIdx] % 2 != 0) {
                if (oddIdx == A.length - 1) {
                    return A;
                }
                oddIdx += 2;
            }
            while (A[evenIdx] % 2 == 0) {
                if (evenIdx == A.length - 2) {
                    return A;
                }
                evenIdx += 2;
            }
            int temp = A[oddIdx];
            A[oddIdx] = A[evenIdx];
            A[evenIdx] = temp;
            oddIdx += 2;
            evenIdx += 2;
        }
        return A;
    }
}
