package easy;

/**
 * @author wuping
 * @date 2018/9/27
 */

public class Longest_Common_Prefix_14 {
    public static void main(String[] args) {
        String[] s = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int t = -1;
        while (true) {
            boolean flag = true;
            int idx = t + 1;
            if (idx > strs[0].length() - 1) {
                break;
            }
            char temp = strs[0].charAt(idx);
            for (int i = 1; i < strs.length; i++) {
                if (idx > strs[i].length() - 1 || strs[i].charAt(idx) != temp) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            t = idx;
        }
        return strs[0].substring(0, t + 1);
    }
}
