package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ping.wu on 2016/12/29.
 */
public class First_Unique_Character_387 {
    public static void main(String[] args) {
        String s = "aadadaad";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<String, Integer> map = new LinkedHashMap();
        char[] s_arr = s.toCharArray();
        for (int i = 0; i < s_arr.length; i++) {
            char t = s_arr[i];
            String temp = String.valueOf(t);
            if (map.containsKey(temp)) {
                map.put(temp, -1);
            } else {
                map.put(temp, i);
            }
        }
        if (map.size() == 0) {
            return -1;
        } else {
            for(String k : map.keySet()) {
                if (map.get(k) >= 0) {
                    return map.get(k);
                }
            }
        }
        return -1;
    }
}
