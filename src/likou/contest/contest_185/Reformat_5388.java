package likou.contest.contest_185;

/**
 * @author wuping
 * @date 2020-04-19
 */

public class Reformat_5388 {
    public static void main(String[] args) {
        String s = "a0b1c2";
        System.out.println(new Reformat_5388().reformat(s));
    }

    public String reformat(String s) {
        int[] t = new int[256];
        for (int i = 0; i < s.length(); i++) {
            t[s.charAt(i)]++;
        }
        int numCount = 0;
        for (int i = '0'; i <= '9'; i++) {
            numCount += t[i];
        }
        int charCount = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            charCount += t[i];
        }
        if (numCount > charCount + 1 || charCount> numCount + 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int numIdx = '0';
        int charIdx = 'a';
        if (numCount > charCount) {
            int temp = charCount;
            while (temp-- > 0) {
                while (t[numIdx] == 0) {
                    numIdx++;
                }
                while (t[charIdx] == 0) {
                    charIdx++;
                }
                sb.append((char) numIdx).append((char) charIdx);
                t[numIdx]--;
                t[charIdx]--;
            }
            while (t[numIdx] == 0) {
                numIdx++;
            }
            sb.append((char) numIdx);
        } else {
            int temp = numCount;
            while (temp-- > 0) {
                while (t[numIdx] == 0) {
                    numIdx++;
                }
                while (t[charIdx] == 0) {
                    charIdx++;
                }
                t[numIdx]--;
                t[charIdx]--;
                sb.append((char) charIdx).append((char) numIdx);
            }
            if (numCount < charCount) {
                while (t[charIdx] == 0) {
                    charIdx++;
                }
                sb.append((char) charIdx);
            }
        }
        return sb.toString();
    }
}
