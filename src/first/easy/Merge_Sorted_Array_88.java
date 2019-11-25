package first.easy;

/**
 * Created by Administrator on 2017/12/29.
 */
public class Merge_Sorted_Array_88 {
    public static void main(String[] args) {
        merge(new int[]{1, 0}, 1, new int[]{2}, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp_m = m;
        int temp_n = n;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (temp_m > 0 && temp_n > 0) {
                int temp1 = nums1[temp_m - 1];
                int temp2 = nums2[temp_n - 1];
                if (temp1 > temp2) {
                    nums1[i] = temp1;
                    temp_m--;
                } else {
                    nums1[i] = temp2;
                    temp_n--;
                }
            } else if (temp_m > 0) {
                nums1[i] = nums1[temp_m - 1];
                temp_m--;
            } else {
                nums1[i] = nums2[temp_n - 1];
                temp_n--;
            }
        }
        if (nums1.length != m + n) {
            int start = nums1.length - m - n;
            for (int i = 0; i < m + n; i++) {
                nums1[i] = nums1[start + i];
            }
            for (int i = m + n; i < nums1.length; i++) {
                nums1[i] = 0;
            }
        }
    }
}
