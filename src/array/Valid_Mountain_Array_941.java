package array;

/**
 * @author wuping
 * @date 2019-07-25
 * https://leetcode.com/problems/valid-mountain-array/
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */

public class Valid_Mountain_Array_941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        boolean increaseFlag = true;
        if (A[1] < A[0]) {
            return false;
        }
        for (int i = 2; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (increaseFlag) {
                    continue;
                } else {
                    return false;
                }
            } else if (A[i] < A[i - 1]) {
                if (increaseFlag) {
                    increaseFlag = false;
                } else {
                    continue;
                }
            } else {
                return false;
            }
        }
        return !increaseFlag;
    }
}
