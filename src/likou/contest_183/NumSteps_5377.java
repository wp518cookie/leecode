package likou.contest_183;

/**
 * @author wuping
 * @date 2020-04-05
 * https://leetcode-cn.com/contest/weekly-contest-183/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 *
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 */

public class NumSteps_5377 {
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(new NumSteps_5377().numSteps(s));
    }
    public int numSteps(String s) {
        int count = 0;
        boolean bit = false;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '0') {
                if (bit) {
                    count += 2;
                    bit = true;
                    i--;
                } else {
                    count++;
                    i--;
                }
            } else {
                if (bit) {
                    count++;
                    bit = true;
                    i--;
                } else {
                    if (i == 0) {
                        return count;
                    }
                    bit = true;
                    count += 2;
                    i--;
                }
            }
        }
        return count;
    }
}
