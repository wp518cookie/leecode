package first.easy;

import java.util.Arrays;

/**
 * Created by ping.wu on 2017/4/30.
 */
public class Reshape_the_Matrix_566 {
    public static void main(String[] args) {
        int[][] s = {{1, 2}, {3, 4}};
        System.out.println(Arrays.deepToString(matrixReshape(s, 1, 4)));
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int old_r = nums.length;
        int old_c = nums[0].length;
        if ((old_c * old_r) != (r * c)) {
            return nums;
        } else {
            int index_r = 0;
            int index_c = 0;
            int[][] result = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    for(;;) {
                        if (index_c >= old_c) {
                            index_r++;
                            index_c = 0;
                        } else {
                            result[i][j] = nums[index_r][index_c++];
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}
