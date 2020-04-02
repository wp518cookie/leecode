package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-02
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * <p>
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 */

public class GetSum_371 {
    public int getSum(int a, int b) {
        String as = Integer.toBinaryString(a);
        String bs = Integer.toBinaryString(b);
        boolean flag = false;
        int al = as.length();
        int bl = bs.length();
        int[] s = new int[32];
        for (int i = 0; i < 32; i++) {
            boolean currentFlag = false;
            int t1 = 0;
            int idx1 = al - i - 1;
            if (idx1 < al && idx1 >= 0 && as.charAt(idx1) == '1') {
                t1 = 1;
            }
            int t2 = 0;
            int idx2 = bl - i - 1;
            if (idx2 < bl && idx2 >= 0 && bs.charAt(idx2) == '1') {
                t2 = 1;
            }
            int t = 0;
            if ((t1 & t2) == 1) {
                if (flag) {
                    t = 1;
                }
                currentFlag = true;
            } else if ((t1 | t2) == 1) {
                if (flag) {
                    t = 0;
                    currentFlag = true;
                } else {
                    t = 1;
                }
            } else if (flag) {
                t = 1;
            }
            s[31 - i] = t;
            flag = currentFlag;
        }
        StringBuilder sb = new StringBuilder();
        if (s[0] == 1) {
            boolean subFlag = true;
            for (int i = 31; i > 0; i--) {
                if (s[i] == 1) {
                    if (subFlag) {
                        s[i] = 0;
                        break;
                    }
                } else {
                    if (subFlag) {
                        s[i] = 1;
                    }
                }
            }
            for (int i = 31; i > 0; i--) {
                if (s[i] == 1) {
                    s[i] = 0;
                } else {
                    s[i] = 1;
                }
            }
            for (int i = 1; i < 32; i++) {
                sb.append(s[i]);
            }
            return -Integer.parseInt(sb.toString(), 2);
        } else {
            for (int i = 1; i < 32; i++) {
                sb.append(s[i]);
            }
            return Integer.parseInt(sb.toString(), 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GetSum_371().getSum(-2, -3));
    }
}
