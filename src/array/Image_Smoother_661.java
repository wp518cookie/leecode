package array;

/**
 * @author wuping
 * @date 2019-07-19
 * https://leetcode.com/problems/image-smoother/
 */

public class Image_Smoother_661 {
    public int[][] imageSmoother(int[][] M) {
        int rowLen = M.length;
        int colLen = M[0].length;
        int[][] result = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int sum = M[i][j];
                int count = 1;
                if (i > 0) {
                    sum += M[i - 1][j];
                    count++;
                }
                if (i < rowLen - 1) {
                    sum += M[i + 1][j];
                    count++;
                }
                if (j > 0) {
                    sum += M[i][j - 1];
                    count++;
                }
                if (j < colLen - 1) {
                    sum += M[i][j + 1];
                    count++;
                }
                if (i > 0 && j > 0) {
                    sum += M[i - 1][j - 1];
                    count++;
                }
                if (i < rowLen - 1 && j > 0) {
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (i > 0 && j < colLen - 1) {
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (i < rowLen - 1 && j < colLen - 1) {
                    sum += M[i + 1][j + 1];
                    count++;
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
