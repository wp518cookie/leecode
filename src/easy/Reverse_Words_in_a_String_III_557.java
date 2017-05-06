package easy;

/**
 * Created by 平 on 2017/4/14.
 */
public class Reverse_Words_in_a_String_III_557 {
    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] x = s.split(" ");
        for (int i = 0; i < x.length; i++) {
            char[] s_arr = x[i].toCharArray();
            for (int j = 0; j < s_arr.length / 2; j++) {
                char t = s_arr[j];
                s_arr[j] = s_arr[s_arr.length - 1 - j];
                s_arr[s_arr.length - 1 - j] = t;
            }
            sb.append(new String(s_arr)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
