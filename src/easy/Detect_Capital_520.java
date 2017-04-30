package easy;

/**
 * Created by ping.wu on 2017/4/20.
 */
public class Detect_Capital_520 {
    public static void main(String[] args) {
        String s = "HELLi";
        System.out.println(detectCapitalUse(s));
    }

    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return false;
        } else if (word.length() == 1) {
            return true;
        }
        char[] s = word.toCharArray();
        if (s[0] >= 97 && s[0] <= 122) {
                for (int i = 1; i < word.length(); i++) {
                    if (s[i] < 97) {
                        return false;
                    }
                }
        }
        if (s[0] >= 65 && s[0] <= 90) {
            if (s[1] > 90) {
                for (int i = 2; i < word.length(); i++) {
                    if (s[i] <= 90) {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < word.length(); i++) {
                    if (s[i] > 90) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
