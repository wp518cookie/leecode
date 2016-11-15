package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ping.wu on 2016/11/15.
 */
public class Find_All_Anagrams_in_a_String_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s != null && p != null && s.length() >= p.length()) {
            for (int i = 0; i < s.length() - p.length() + 1; i++) {
                String temp_s = s.substring(i, i + p.length());
                StringBuilder temp_p = new StringBuilder();
                boolean flag = true;
                for (int j = 0; j < p.length(); j++) {
                    if (temp_p.length() <= 0) {
                        temp_p.append(p.charAt(j));
                    } else {
                        if (temp_p.charAt(temp_p.length() - 1) == p.charAt(j)) {
                            temp_p.append(p.charAt(j));
                        } else {
                            if (!temp_s.contains(temp_p)) {
                                flag = false;
                            } else {
                                temp_p = new StringBuilder();
                                temp_p.append(p.charAt(j));
                            }
                        }
                    }
                }
                if (!temp_p.equals("") && !temp_s.contains(temp_p)) {
                    flag = false;
                }
                if (flag) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}