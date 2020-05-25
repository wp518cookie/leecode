package likou.contest.contest_182;

/**
 * @author wuping
 * @date 2020-03-29
 * https://leetcode-cn.com/contest/weekly-contest-182/problems/find-all-good-strings/
 */

public class FindGoodStrings_5371 {
    private long limit = 1000000000 + 7;

    public static void main(String[] args) {
        System.out.println(new FindGoodStrings_5371().gap("aa", "da"));
    }

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if (s1.compareTo(s2) > 0) {
            return 0;
        }
        if (s1.startsWith(evil) && s2.startsWith(evil)) {
            return 0;
        }
        long removed = 0;
        for (int i = 1; i < n - evil.length() + 1; i++) {

        }
        return -1;
    }

    public long gap(String s1, String s2) {
        long sum1 = 0;
        long count1 = 26;
        long rest1 = 1;
        for (int i = s1.length() - 1; i >= 0; i--) {
            sum1 += count1 * (s1.charAt(i) - 'a' + 1);
            count1 = count1 * 26;
            if (sum1 > limit) {
                rest1 *= sum1 % limit;
                sum1 = 0;
            }
            if (count1 > limit) {
                rest1 *= count1 % limit;
                count1 = 26;
            }
            if (rest1 > limit) {
                rest1 = rest1 % limit;
            }
        }
        long sum2 = 0;
        long count2 = 26;
        long rest2 = 0;
        for (int i = s2.length() - 1; i >= 0; i--) {
            sum2 += count2 * (s2.charAt(i) - 'a' + 1);
            count2 = count2 * 26;
            if (sum2 > limit) {
                rest2 = sum2 % limit;
                sum2 = 0;
            }
            if (count2 > limit) {
                rest2 += count2 % limit;
                count2 = 26;
            }
            if (rest2 > limit) {
                rest2 = rest2 % limit;
            }
        }
        sum1 += rest1;
        sum2 += rest2;
        long result = sum2 - sum1;
        if (result < 0) {
            result += limit;
        }
        return result;
    }
}
