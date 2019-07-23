package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-22
 * https://leetcode.com/problems/find-common-characters/
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 */

public class Common_Chars_1002 {
    public static void main(String[] args) {
        String[] arr = new String[]{"bella","label","roller"};
        List<String> result = new Common_Chars_1002().commonChars(arr);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList();
        if (A == null || A.length == 0) {
            return result;
        }
        int[][] mark = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char t : A[i].toCharArray()) {
                int idx = ((int) t) - 97;
                mark[i][idx]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j++) {
                min = Math.min(min, mark[j][i]);
            }
            if (min == 0) {
                continue;
            }
            String s = String.valueOf((char) (i + 97));
            for (int k = 0; k < min; k++) {
                result.add(s);
            }
        }
        return result;
    }
}
