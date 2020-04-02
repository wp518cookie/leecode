package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-02
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            String preStr = null;
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < pre.length(); j++) {
                if (preStr == null) {
                    preStr = String.valueOf(pre.charAt(j));
                    count = 1;
                } else {
                    if (preStr.equals(String.valueOf(pre.charAt(j)))) {
                        count++;
                    } else {
                        sb.append(count).append(preStr);
                        preStr = String.valueOf(pre.charAt(j));
                        count = 1;
                    }
                }
            }
            if (count > 0) {
                sb.append(count).append(preStr);
            }
            pre = sb.toString();
        }
        return pre;
    }
}
