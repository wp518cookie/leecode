package hashtable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ping.wu on 2016/12/7.
 */
public class Sum_II_454 {
    public static void main(String[] args) {
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};
        System.out.println(fourSumCount(A, B, C, D));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) {
            return 0;
        } else {
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    Integer temp = A[i] + B[j];
                    if (map.get(temp) == null) {
                        map.put(temp, 1);
                    } else {
                        map.put(temp, map.get(temp) + 1);
                    }
                }
            }
            Map<Integer, Integer> map1 = new HashMap();
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    Integer temp = C[i] + D[j];
                    if (map1.get(temp) == null) {
                        map1.put(temp, 1);
                    } else {
                        map1.put(temp, map1.get(temp) + 1);
                    }
                }
            }
            int count = 0;
            for(Integer i : map.keySet()) {
                if (map1.get(-i) != null) {
                    count += map.get(i) * map1.get(-i);
                }
            }
            return count;
        }
    }
}
