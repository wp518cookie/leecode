package likou.contest.contest_194;

/**
 * @author wuping
 * @date 2020-06-21
 * https://leetcode-cn.com/contest/weekly-contest-194/problems/xor-operation-in-an-array/
 */

public class XorOperation {
    public int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }
        int count = 1;
        int result = start;
        while (count < n) {
            result = result ^ (start + count * 2);
            count++;
        }
        return result;
    }
}
