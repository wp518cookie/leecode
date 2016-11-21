package easy;

import java.util.HashMap;

/**
 * Created by ping.wu on 2016/11/21.
 */
public class Repeated_Substring_Pattern_459 {
    public static void main(String[] args) {
        String str = "abab";
        System.out.println(repeatedSubstringPattern1(str));
    }

    public static boolean repeatedSubstringPattern1(String str) {
        char[] s = str.toCharArray();
        int temp = 0;
        for (int i = 0; i < s.length; i++) {
            temp ^= s[i];
            if (temp == 0) {
                boolean result = true;
                int cursor = (i + 1) / 2;
                if (str.length() % cursor != 0) {
                    continue;
                }
                int times = str.length() / cursor;
                outterLoop:
                for (int j = 1; j < times; j++) {
                    for (int k = 0; k < cursor; k++) {
                        if (s[k] != s[cursor * j + k]) {
                            result = false;
                            break outterLoop;
                        }
                    }
                }
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String str) {
        char[] s = str.toCharArray();
        int temp = 0;
        for (int i = 0; i < s.length; i++) {
            temp ^= s[i];
            if (temp == 0) {
                boolean result = true;
                int cursor = (i + 1) / 2;
                if (str.length() % cursor != 0) {
                    continue;
                }
                int times = str.length() / cursor;
                HashMap<String, String> map = new HashMap();
                map.put(str.substring(0, cursor), "");
                for (int j = 1; j < times; j++) {
                    map.put(str.substring(cursor * j, cursor * (j + 1)), "");
                    if (map.size() > 1) {
                        break;
                    }
                }
                if (map.size() == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
