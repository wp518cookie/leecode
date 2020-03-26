package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-26
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */

public class Merge_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || n == 0) {
            return;
        }
        int idx = nums1.length - 1;
        int idxM = m - 1;
        int idxN = n - 1;
        while (idxM >= 0 && idxN >= 0) {
            if (nums1[idxM] > nums2[idxN]) {
                nums1[idx--] = nums1[idxM--];
            } else {
                nums1[idx--] = nums2[idxN--];
            }
        }
        while (idxN >= 0) {
            nums1[idx--] = nums2[idxN--];
        }
    }
}
