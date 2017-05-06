package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2016/11/15.
 */
public class Find_All_Anagrams_in_a_String_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        if (s.length() > p.length()) {
            int[] letter = new int[26];
            boolean flag = true;
            for (int i = 0; i < p.length(); i++) {
                int p_value = p.charAt(i);
                letter[p_value - 97] += 1;
                int s_value = s.charAt(i);
                letter[s_value - 97] -= 1;
            }
            for (int i : letter) {
                if (i != 0) {
                    flag = false;
                }
            }
            if (flag) {
                list.add(0);
            }
            for (int i = 1; i < s.length() - p.length() + 1; i++) {
                boolean flag1 = true;
                letter[s.charAt(i - 1) - 97] += 1;
                letter[s.charAt(i + p.length() - 1) - 97] -= 1;
                for (int j : letter) {
                    if (j != 0) {
                        flag1 = false;
                    }
                }
                if (flag1) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}