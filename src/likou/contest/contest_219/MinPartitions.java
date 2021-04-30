package likou.contest.contest_219;

/**
 * @author wuping
 * @date 2020-12-13
 * https://leetcode-cn.com/contest/weekly-contest-219/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */

public class MinPartitions {
    public static void main(String[] args) {
        System.out.println(new MinPartitions().minPartitions("82734"));
    }

    public int minPartitions(String n) {
        char t = '1';
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) > t) {
                t = n.charAt(i);
            }
        }
        return t - '0';
    }
}
