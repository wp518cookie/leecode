package easy;

/**
 * Created by ping.wu on 2016/11/14.
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(reverseString3(s));
    }

    public static String reverseString1(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
            sb.reverse();
        }
        return sb.toString();
    }

    public static String reverseString2(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static String reverseString3(String s) {
        if(s == null || "".equals(s)) {
            return "";
        }
        int start = 0;
        int end = s.length()-1;
        char[] schars = s.toCharArray();
        while(start < end) {
            char temp = schars[start];
            schars[start++] = schars[end];
            schars[end--] = temp;
        }
        return new String(schars);
    }
}
