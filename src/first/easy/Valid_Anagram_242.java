package first.easy;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class Valid_Anagram_242 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] s_val = new int[26];
        int[] t_val = new int[26];
        for (int i = 0; i < s_arr.length; i++) {
            s_val[s_arr[i] - 97]++;
        }
        for (int i = 0; i < t_arr.length; i++) {
            t_val[t_arr[i] - 97]++;
        }
        for (int i = 0; i < s_val.length; i++) {
            if (s_val[i] != t_val[i]) {
                return false;
            }
        }
        return true;
    }
}
