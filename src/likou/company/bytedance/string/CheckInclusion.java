package likou.company.bytedance.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-06-15
 *
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1016/
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */

public class CheckInclusion {
    public static void main(String[] args) {
        System.out.println(new CheckInclusion().checkInclusion("ab", "eidbaooo"));
    }

    //-------------------------------- 官方解法之数组 --------------------------------
//    public boolean checkInclusion(String s1, String s2) {
//        int[] mark1 = new int[26];
//        int[] mark2 = new int[26];
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char t = s1.charAt(i);
//            mark1[t - 'a']++;
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char t = s2.charAt(i);
//            mark2[t - 'a']++;
//        }
//        if (isTheSame(mark1, mark2)) {
//            return true;
//        }
//        int length = s1.length();
//        for (int i = length; i < s2.length(); i++) {
//            mark2[s2.charAt(i - length) - 'a']--;
//            mark2[s2.charAt(i) - 'a']++;
//            if (isTheSame(mark1, mark2)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isTheSame(int[] mark1, int[] mark2) {
//        for (int i = 0; i < mark1.length; i++) {
//            if (mark1[i] != mark2[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
    // 滑动窗口之优化，避免每次去比较
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] mark = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            mark[s2.charAt(i) - 'a']--;
        }
        int count = 26;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 0) {
                count--;
            }
            if (count == 0) {
                return true;
            }
        }
        int length = s1.length();
        for (int i = length; i < s2.length(); i++) {
            char pre = s2.charAt(i - length);
            char cur = s2.charAt(i);
            if (pre == cur) {
                continue;
            }
            mark[pre - 'a']++;
            if (mark[pre - 'a'] == 1) {
                count++;
            }
            if (mark[pre - 'a'] == 0) {
                count--;
            }
            mark[cur - 'a']--;
            if (mark[cur - 'a'] == 0) {
                count--;
            }
            if (mark[cur - 'a'] == -1) {
                count++;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------------

//    我的解法
//    public boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//        Map<Character, Integer> count = new HashMap();
//        for (int i = 0; i < s1.length(); i++) {
//            char t = s1.charAt(i);
//            if (count.containsKey(t)) {
//                count.put(t, count.get(t) + 1);
//            } else {
//                count.put(t, 1);
//            }
//        }
//        int length1 = s1.length();
//        int length2 = s2.length();
//        int leftIdx = 0;
//        int rightIdx = 0;
//        while (true) {
//            if (leftIdx + length1 - 1 >= length2) {
//                return false;
//            }
//            char t1 = s2.charAt(leftIdx);
//            if (!count.containsKey(t1)) {
//                leftIdx++;
//                continue;
//            } else {
//                removeFromMap(count, t1);
//                if (count.size() == 0) {
//                    return true;
//                }
//            }
//            rightIdx = Math.max(rightIdx, leftIdx + 1);
//            while (rightIdx < length2) {
//                char t2 = s2.charAt(rightIdx);
//                if (count.containsKey(t2)) {
//                    removeFromMap(count, t2);
//                    if (count.size() == 0) {
//                        return true;
//                    }
//                    rightIdx++;
//                } else {
//                    while (leftIdx < rightIdx) {
//                        t1 = s2.charAt(leftIdx);
//                        if (t1 == t2) {
//                            leftIdx++;
//                            rightIdx++;
//                            break;
//                        } else {
//                            putIntoMap(count, t1);
//                            leftIdx++;
//                        }
//                    }
//                    if (leftIdx == rightIdx) {
//                        leftIdx = rightIdx + 1;
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    public void removeFromMap(Map<Character, Integer> count, char t) {
//        if (count.get(t) == 1) {
//            count.remove(t);
//        } else {
//            count.put(t, count.get(t) - 1);
//        }
//    }
//
//    public void putIntoMap(Map<Character, Integer> count, char t) {
//        if (count.containsKey(t)) {
//            count.put(t, count.get(t) + 1);
//        } else {
//            count.put(t, 1);
//        }
//    }
}
