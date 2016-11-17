package easy;

import java.util.Arrays;

/**
 * Created by ping.wu on 2016/11/17.
 * Input: [1,2], [1,2,3]   Input: [1,2,3], [1,1]
 * children  cookie
 */

public class Assign_Cookies_455 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{1, 2, 3};
        System.out.println(findContentChildren(a, b));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int num = 0;
        int cursor = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] >= g[cursor]) {
                num++;
                if (cursor > 0) {
                    cursor--;
                } else {
                    break;
                }
            } else {
                if (cursor > 0) {
                    cursor--;
                    i++;
                } else {
                    break;
                }
            }
        }
        return num;
    }
}
