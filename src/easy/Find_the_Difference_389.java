package easy;

/**
 * Created by ping.wu on 2016/11/16.
 */
public class Find_the_Difference_389 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(findTheDifference(s, t));
    }

    public static char findTheDifference(String s, String t) {
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            t = t.replaceFirst(String.valueOf(c), "");
        }
        if (t.length() == 0) {
            return '\u0000';
        } else {
            return t.toCharArray()[0];
        }
    }
}
