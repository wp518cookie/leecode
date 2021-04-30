package likou.contest.contest_234;

/**
 * @author wuping
 * @date 2021-03-28
 * https://leetcode-cn.com/contest/weekly-contest-234/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 */

public class ReinitializePermutation {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new ReinitializePermutation().reinitializePermutation(200));
        System.out.println(System.currentTimeMillis() - start);
    }

    public int reinitializePermutation(int n) {
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = i;
        }
        int count = 0;
        int idx = n / 2;
        while (true) {
            int[] arr = new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int temp = i % 2 == 0 ? t[i / 2] : t[idx + (i - 1) / 2];
                if (temp != i) {
                    flag = false;
                }
                arr[i] = temp;
            }
            t = arr;
            count++;
            if (flag) {
                return count;
            }
        }
    }
}
