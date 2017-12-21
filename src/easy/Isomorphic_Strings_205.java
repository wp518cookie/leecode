package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/24.
 */
public class Isomorphic_Strings_205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("aa","ab"));
    }
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map_st = new HashMap();
        Map<Character, Character> map_ts = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character temp_s = s.charAt(i);
            Character temp_t = t.charAt(i);
            if (map_st.get(temp_s) == null && map_ts.get(temp_t) == null) {
                map_st.put(temp_s, temp_t);
                map_ts.put(temp_t, temp_s);
            } else if (map_st.get(temp_s) != null && map_ts.get(temp_t) != null) {
                if (!temp_t.equals(map_st.get(temp_s)) || !temp_s.equals(map_ts.get(temp_t))) {
                    return false;
                }
            } else if (map_st.get(temp_s) != null || map_ts.get(temp_t) != null) {
                return false;
            }
        }
        return true;
    }
}
