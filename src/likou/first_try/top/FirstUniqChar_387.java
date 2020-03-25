package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-03-25
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 */

public class FirstUniqChar_387 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new FirstUniqChar_387().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        int[] temp = new int[128];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (temp[t] == -1) {
                temp[t] = i;
            } else if (temp[t] >= 0) {
                temp[t] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= 0) {
                min = Math.min(min, temp[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
