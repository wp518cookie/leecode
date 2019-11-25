package first.medium;

/**
 * Created by Administrator on 2018/4/3.
 */
public class Longest_Palindromic_5 {
    public static void main(String[] args) {
        String s = "abcba";
        longestPalindromic(s);
    }

    public static String longestPalindromic(String s) {
        char[] cStr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append("#");
        for (int i = 0; i < cStr.length; i++) {
            sb.append(cStr[i]);
            sb.append("#");
        }
        int id = 0;
        int max = 0;
        int[] p = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i < max) {
                p[i] = Math.min(p[2 * id - i], max - i);
            } else {
                p[i] = 1;
            }
            while (i - p[i] >= 0 && i + p[i] < sb.length()
                    && sb.charAt(i - p[i]) == sb.charAt(i + p[i])) {
                p[i]++;
            }
            if (i + p[i] > max) {
                max = i + p[i];
                id = i;
            }
        }
        int maxl = 0;
        int maxid = 0;
        for (int i = 0; i < p.length; i++) {
            if (maxl < p[i]) {
                maxl = p[i];
                maxid = i;
            }
        }
        int r = maxl - 1;
        int start = maxid - r + 1;
        int end = maxid + maxl - 1;
        StringBuffer out = new StringBuffer();
        for (int i = start; i < end; i++) {
            if (sb.charAt(i) != '#') {
                out.append(sb.charAt(i));
            }
        }
        return out.toString();
    }
}
