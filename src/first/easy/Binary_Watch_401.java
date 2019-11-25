package first.easy;

import java.util.*;

/**
 * Created by ping.wu on 2017/1/19.
 */
public class Binary_Watch_401 {
    public static void main(String[] args) {
        readBinaryWatch(1);
    }

    public static List<String> readBinaryWatch(int num) {
        int[] hours = {1, 2, 4, 8};
        Map<Integer, Set<Integer>> hour_map = new HashMap();
        for (int i = 0;i <= 4; i++ ) {
            if (i == 0) {
                Set set = new HashSet();
                set.add(0);
                hour_map.put(0, set);
            }
            while (i-- > 0) {

            }
        }
        return null;
    }
}
