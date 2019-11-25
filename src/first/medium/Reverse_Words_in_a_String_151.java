package first.medium;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Reverse_Words_in_a_String_151 {
    public static void main(String[] args) throws Exception {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 32) {
                temp.append(arr[i]);
            } else {
                if (temp.length() > 0) {
                    sb.append(temp.reverse().toString()).append(" ");
                    temp = new StringBuilder();
                }
            }
        }
        if (temp.length() > 0) {
            sb.append(temp.reverse().toString());
        }
        return sb.toString().trim();
    }
}
