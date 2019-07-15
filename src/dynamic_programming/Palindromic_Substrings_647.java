package dynamic_programming;

/**
 * @author wuping
 * @date 2019-07-12
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 */

public class Palindromic_Substrings_647 {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromic(s.substring(i, j + 1))) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPalindromic(String s) {
        if (s.length() == 1) {
            return true;
        }
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
