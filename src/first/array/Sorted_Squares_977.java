package first.array;

/**
 * @author wuping
 * @date 2019-07-16
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */

public class Sorted_Squares_977 {
    public int[] sortedSquares(int[] A) {
        int length = A.length;
        int start = 0;
        int end = length - 1;
        int[] result = new int[length];
        int curIdx = length - 1;
        while (start <= end) {
            if (A[start] < 0 && -A[start] >= A[end]) {
                result[curIdx--] = A[start] * A[start];
                start++;
                continue;
            } else {
                result[curIdx--] = A[end] * A[end];
                end--;
                continue;
            }
        }
        return result;
    }
}
