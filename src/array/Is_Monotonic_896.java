package array;

/**
 * @author wuping
 * @date 2019-07-19
 * https://leetcode.com/problems/monotonic-array/
 */

public class Is_Monotonic_896 {
    public boolean isMonotonic(int[] A) {
        boolean increaseFlag = false;
        boolean decreaseFlag = false;
        if (A == null || A.length <= 1) {
            return true;
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (decreaseFlag) {
                    return false;
                }
                increaseFlag = true;
            } else if (A[i] < A[i - 1]) {
                if (increaseFlag) {
                    return false;
                }
                decreaseFlag = true;
            } else {
                continue;
            }
        }
        return true;
    }
}
