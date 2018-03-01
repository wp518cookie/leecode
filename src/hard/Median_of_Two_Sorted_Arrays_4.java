package hard;

/**
 * Created by Administrator on 2018/3/1.
 */
public class Median_of_Two_Sorted_Arrays_4 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 2}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index_1 = 0;
        int index_2 = 0;
        int length_1 = nums1.length;
        int length_2 = nums2.length;
        float temp1 = 0;
        float temp2 = 0;
        while (true) {
            if (length_1 == 1 && length_2 == 1) {
                return ((double)nums1[0 + index_1] + (double)nums2[0 + index_2]) / 2;
            }
            if (length_1 > 1 && length_2 > 1) {
                boolean flag1 = false;
                boolean flag2 = false;
                if (length_1 % 2 == 0) {
                    length_1 = length_1 / 2;
                    temp1 = (nums1[index_1 + length_1 - 1] + nums1[index_1 + length_1]) / 2;
                } else {
                    length_1 = length_1 / 2;
                    temp1 = nums1[index_1 + length_1];
                    flag1 = true;
                }
                if (length_2 % 2 == 0) {
                    length_2 = length_2 / 2;
                    temp2 = (nums2[index_2 + length_2 - 1] + nums2[index_2 + length_2]) / 2;
                } else {
                    length_2 = length_2 / 2;
                    temp2 = nums2[index_2 + length_2];
                    flag2 = true;
                }
                if (temp1 > temp2) {
                    index_2 = index_2 + length_2 + (flag2 ? 1 : 0);
                } else if (temp1 < temp2) {
                    index_1 = index_1 + length_1 + (flag1 ? 1 : 0);
                } else {
                    return temp1;
                }
            } else if (length_1 > 1) {
                if (length_1 % 2 == 0) {
                    return ((double)nums1[index_1 + (length_1 / 2) - 1] + (double)nums1[index_1 + length_1 / 2]) / 2;
                } else {
                    return (double)nums1[index_1 + length_1 / 2];
                }
            } else {
                if (length_2 % 2 == 0) {
                    return ((double)nums2[index_2 + (length_2 / 2) - 1] + (double)nums2[index_2 + length_2 / 2]) / 2;
                } else {
                    return (double)nums2[index_2 + length_2 / 2];
                }
            }
        }

    }
}
