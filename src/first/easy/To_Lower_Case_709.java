package first.easy;

/**
 * @author wuping
 * @date 2018/9/19
 */

public class To_Lower_Case_709 {
    public static void main(String[] args) {
        System.out.println(toLowerCase("HELLO"));
    }

    public static String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int start = 65;
        int end = 90;
        int gap = 32;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c >= 65 && c <= 90) {
                arr[i] = (char)(c + gap);
            }
        }
        return new String(arr);
    }
}
