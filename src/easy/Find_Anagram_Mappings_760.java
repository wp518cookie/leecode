package easy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/17.
 */
public class Find_Anagram_Mappings_760 {
    public static void main(String[] args) {
        int[] a = new int[]{12, 28, 46, 32, 50};
        int[] b = new int[]{50, 12, 32, 46, 28};
        System.out.println(Arrays.toString(anagramMappings(a, b)));
    }
    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = map.get(A[i]);
        }
        return result;
    }
}
