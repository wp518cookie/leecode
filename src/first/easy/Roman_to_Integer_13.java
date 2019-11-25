package first.easy;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class Roman_to_Integer_13 {
    public static void main(String[] args) {
        String s = "MCMXCVI";
    }

    public static int romanToInt(String s) {
        char[] s_arr = s.toCharArray();
        int result = 0;
        for (int i = 0; i < s_arr.length; i++) {
            if (s_arr[i] == 'I') {
                result += 1;
            } else if (s_arr[i] == 'X') {
                result += 10;
            } else if (s_arr[i] == 'C') {
                result += 100;
            } else if (s_arr[i] == 'M') {
                result += 1000;
            } else if (s_arr[i] == 'V') {
                result += 5;
            } else if (s_arr[i] == 'L') {
                result += 50;
            } else if (s_arr[i] == 'D') {
                result += 500;
            }
        }
        return result;
    }
}
