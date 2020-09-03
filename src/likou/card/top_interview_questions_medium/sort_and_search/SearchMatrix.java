package likou.card.top_interview_questions_medium.sort_and_search;

/**
 * @author wuping
 * @date 2020-09-01
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvc64r/
 * <p>
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new SearchMatrix().searchMatrix(arr, 5));
    }

    /**
     * 优秀解答
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            int t = matrix[i][j];
            if (t > target) {
                i--;
            } else if (t < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 执行用时：
     * 8 ms, 在所有 Java 提交中击败了32.74%的用户
     * 内存消耗：
     * 45.2 MB, 在所有 Java 提交中击败了74.44%的用户
     * @param matrix
     * @param target
     * @return
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//        int row = matrix.length;
//        int col = matrix[0].length;
//        boolean flag = true;
//        if (row > col) {
//            flag = false;
//        }
//        if (flag) {
//            for (int i = 0; i < row; i++) {
//                if (binarySearch(matrix, i, col, flag, target)) {
//                    return true;
//                }
//            }
//        } else {
//            for (int i = 0; i < col; i++) {
//                if (binarySearch(matrix, i, row, flag, target)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean binarySearch(int[][] matrix, int i, int length, boolean flag, int target) {
//        if (flag) {
//            if (matrix[i][0] > target || matrix[i][length - 1] < target) {
//                return false;
//            }
//            int l = 0;
//            int r = length - 1;
//            while (l < r) {
//                int mid = (l + r) / 2;
//                if (matrix[i][mid] < target) {
//                    l = mid + 1;
//                } else if (matrix[i][mid] > target) {
//                    r = mid - 1;
//                } else {
//                    return true;
//                }
//            }
//            return matrix[i][l] == target;
//        } else {
//            if (matrix[0][i] > target || matrix[length - 1][i] < target) {
//                return false;
//            }
//            int l = 0;
//            int r = length - 1;
//            while (l < r) {
//                int mid = (l + r) / 2;
//                if (matrix[mid][i] < target) {
//                    l = mid + 1;
//                } else if (matrix[mid][i] > target) {
//                    r = mid - 1;
//                } else {
//                    return true;
//                }
//            }
//            return matrix[l][i] == target;
//        }
//    }
}
