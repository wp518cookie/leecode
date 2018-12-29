package medium;

import java.util.Arrays;

/**
 * @author wuping
 * @date 2018/12/28
 */

public class Rotate_Image_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};
//        int[][] matrix = new int[2][2];
//        matrix[0] = new int[]{1, 2};
//        matrix[1] = new int[]{3, 4};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < matrix.length/2) {
            int tEnd = end - start;
            for (int i = start; i < tEnd; i++) {
                int t = end - i;
                int temp = matrix[start][i];
                matrix[start][i] = matrix[t][start];
                matrix[t][start] = matrix[tEnd][t];
                matrix[tEnd][t] = matrix[i][tEnd];
                matrix[i][tEnd] = temp;
            }
            start++;
        }
    }
}
