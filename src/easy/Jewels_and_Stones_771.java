package easy;

/**
 * @author wuping
 * @date 2018/9/18
 */

public class Jewels_and_Stones_771 {
    public static void main(String[] args) {
        String j = "aA", s = "aAAbbbb";
        System.out.println(numJewelsInStones(j, s));
    }

    public static int numJewelsInStones(String j, String s) {
        if (j == null || j.length() == 0 || s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[100];
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            int idx = c - 30;
            arr[idx]++;
        }
        int result = 0;
        for (char c : j.toCharArray()) {
            int idx = c - 30;
            result += arr[idx];
        }
        return result;
    }
}
