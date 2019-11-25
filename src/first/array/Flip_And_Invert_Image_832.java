package first.array;

/**
 * @author wuping
 * @date 2019-07-16
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 */

public class Flip_And_Invert_Image_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = A[i].length - 1;
            int[] meta = A[i];
            while (start <= end) {
                if (meta[start] != meta[end]) {
                    start++;
                    end--;
                    continue;
                } else if (meta[start] == meta[end]) {
                    if (meta[start] == 0) {
                        meta[start] = 1;
                        meta[end] = 1;
                    } else {
                        meta[start] = 0;
                        meta[end] = 0;
                    }
                    start++;
                    end--;
                    continue;
                }
            }
        }
        return A;
    }
}
