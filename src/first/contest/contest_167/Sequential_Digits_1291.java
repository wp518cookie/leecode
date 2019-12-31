package first.contest.contest_167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wuping
 * @date 2019-12-17
 * https://leetcode.com/contest/weekly-contest-167/problems/sequential-digits/
 *
 * Input: low = 100, high = 300
 * Output: [123,234]
 */

public class Sequential_Digits_1291 {
    public static void main(String[] args) {
        int low = 10;
        int high = 100;
        System.out.println(new Sequential_Digits_1291().sequentialDigits(low, high));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList();
        int highestBit = low;
        int count = 1;
        while (highestBit >= 10) {
            highestBit = highestBit / 10;
            count++;
        }
        while (highestBit + count <= 10) {
            int temp = highestBit + 1;
            int sum = highestBit;
            while (sum <= high) {
                if (sum >= low) {
                    result.add(sum);
                }
                sum = sum * 10 + temp;
                temp++;
            }
            highestBit++;
        }
        Collections.sort(result);
        return result;
    }
}
