package first.easy;

/**
 * @author wuping
 * @date 2018/9/18
 */

public class Jewels_and_Stones_771 {
    public static void main(String[] args) {
        String j = "aA", s = "aAAbbbb";
        System.out.println(numJewelsInStones(j, s));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        int[] c = new int[128];
        for (char t : J.toCharArray()) {
            c[t] = 1;
        }
        int count = 0;
        for (char t : S.toCharArray()) {
            if (c[t] == 1) {
                count++;
            }
        }
        return count;
    }
}
