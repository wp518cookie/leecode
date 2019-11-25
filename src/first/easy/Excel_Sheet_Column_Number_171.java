package first.easy;

/**
 * Created by ping.wu on 2016/12/30.
 */
public class Excel_Sheet_Column_Number_171 {
    public static void main(String[] args) {
        String s = "BA";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        char[] s_arr = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s_arr.length; i++) {
            char temp = s_arr[i];
            int times = 1;
            int index = s_arr.length - i - 1;
            while (index-- > 0) {
                times *= 26;
            }
            count += times * (temp - 64);
        }
        return count;
    }
}
