package first.binary_search;

/**
 * @author wuping
 * @date 2019-07-25
 * https://leetcode.com/problems/first-bad-version/
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 */

public class First_Bad_Version_278 {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid;
        while (start < end) {
            mid = start + ((end - start) >> 1);
            boolean result = isBadVersion(mid);
            if (result) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
