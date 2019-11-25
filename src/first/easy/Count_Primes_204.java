package first.easy;

/**
 * @author wuping
 * @date 2019-10-29
 * https://leetcode.com/problems/count-primes/
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

public class Count_Primes_204 {
    public static void main(String[] args) {
        System.out.println(new Count_Primes_204().countPrimes(10));
    }

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            boolean flag = true;
            for (int j = 3; j * j <= i; j += 2) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
