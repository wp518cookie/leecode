package first.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2018/12/28
 */

public class Generate_Parentheses_22 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> pre1 = new ArrayList();
        pre1.add("()");
        List<String> pre2 = new ArrayList();
        pre2.add("()()");
        pre2.add("(())");
        if (n == 1) {
            return pre1;
        } else if (n == 2) {
            return pre2;
        }
        int t = 2;
        while (t < n) {
            Set<String> cur = new HashSet<>();
            for (String s : pre2) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length - 1; i++) {
                    for (String s1 : pre1) {
                        String meta = s.substring(0, i) + s1 + s.substring(i, arr.length);
                        cur.add(meta);
                    }
                }
            }
            pre1 = pre2;
            pre2 = new ArrayList<>(cur);
            t++;
        }
        return pre2;
    }
}
