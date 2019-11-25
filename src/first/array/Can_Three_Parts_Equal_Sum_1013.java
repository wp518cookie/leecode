package first.array;

/**
 * @author wuping
 * @date 2019-07-18
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */

public class Can_Three_Parts_Equal_Sum_1013 {
    public static void main(String[] args) {
        int[] t = new int[]{0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(new Can_Three_Parts_Equal_Sum_1013().canThreePartsEqualSum(t));
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int temp = sum / 3;
        int count = 1;
        int start = 0;
        while (true) {
            int t = 0;
            if (count < 3) {
                boolean flag = false;
                for (int i = start; i < A.length; i++) {
                    t += A[i];
                    if (temp == t) {
                        count++;
                        start = i + 1;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            } else {
                for (int i = start; i < A.length; i++) {
                    t += A[i];
                }
                if (temp == t) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
