package easy;

/**
 * Created by Administrator on 2018/1/29.
 */
public class Toeplitz_Matrix_766 {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{{1,2,3,4}, {5,1,2,3}, {9,5,1,1}}));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return true;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            int m_i = 0;
            int j = i;
            int t = matrix[m_i][j];
            while (++m_i < m && ++j < n) {
                if (matrix[m_i][j] != t) {
                    return false;
                }
            }
        }
        if (m > 1) {
            //纵坐标
            for (int i = 1; i < m; i++) {
                int m_i = i;
                int j = 0;
                int t = matrix[m_i][j];
                while (++m_i < m && ++j < n) {
                    if (matrix[m_i][j] != t) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}