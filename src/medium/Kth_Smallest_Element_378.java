/*
package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

*/
/**
 * Created by ping.wu on 2016/12/22.
 *//*

public class Kth_Smallest_Element_378 {
    public static void main(String[] args) {
        int[][] test =
                        {{1, 5,  6,  11},
                        {10, 11, 13, 14},
                        {12, 13, 15, 16},
                        {13, 14, 16, 17}};
        System.out.println(kthSmallest(test, 7));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] results = new int[n*n];
        if (k < results.length/2) {
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {
                    int minx = i;
                    int miny = j;
                    if (matrix[i][j] < matrix[minx][miny]) {
                        minx = i;
                        miny = j;
                    }
                }
            }
        }
    }
}
*/
