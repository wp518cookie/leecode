package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-08-03
 * https://leetcode-cn.com/problems/add-strings/
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 */

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int t1 = num1.charAt(i--) - '0';
            int t2 = num2.charAt(j--) - '0';
            int temp = t1 + t2;
            if (flag) {
                temp++;
                flag = false;
            }
            if (temp >= 10) {
                flag = true;
                temp = temp % 10;
            }
            sb.append(temp);
        }
        while (i >= 0) {
            int t = num1.charAt(i) - '0';
            if (flag) {
                t++;
                flag = false;
            }
            if (t >= 10) {
                t = t % 10;
                flag = true;
            }
            sb.append(t);
        }
        while (j >= 0) {
            int t = num2.charAt(j) - '0';
            if (flag) {
                t++;
                flag = false;
            }
            if (t >= 10) {
                t = t % 10;
                flag = true;
            }
            sb.append(t);
        }
        if (flag) {
            sb.append(1);
        }
        StringBuilder result = new StringBuilder();
        for (int k = sb.length() - 1; k >= 0; k--) {
            result.append(sb.charAt(k));
        }
        return result.toString();
    }
}
