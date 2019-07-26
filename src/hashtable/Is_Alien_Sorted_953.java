package hashtable;

/**
 * @author wuping
 * @date 2019-07-26
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */

public class Is_Alien_Sorted_953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length < 2) {
            return true;
        }
        int[] orderArr = new int[128];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i)] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String after = words[i];
            int idx = 0;
            boolean flag = true;
            while (idx < pre.length() && idx < after.length()) {
                int g = orderArr[pre.charAt(idx)] - orderArr[after.charAt(idx)];
                if (g > 0) {
                    return false;
                } else if (g < 0) {
                    flag = false;
                    break;
                }
                idx++;
            }
            if (flag && pre.length() > after.length()) {
                return false;
            }
        }
        return true;
    }
}
