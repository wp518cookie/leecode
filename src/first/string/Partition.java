package first.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019/3/18
 * https://leetcode-cn.com/explore/interview/card/top-interview-quesitons-in-2018/275/string/1137/
 * 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

public class Partition {
    private static List<List<String>> result = new ArrayList();

    public static void main(String[] args) {
        Partition partition = new Partition();
        partition.partition("aab");
        System.out.println(result.toString());
    }

    public List<List<String>> partition(String s) {
        nextWords(s, 0, new ArrayList<>());
        return result;
    }

    private void nextWords(String s, int index, List<String> list) {
        if (index == s.length()) {
            result.add(new ArrayList(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (isPalindrome(str)) {
                list.add(str);
                nextWords(s, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            int t1 = transfer(arr[i]);
            while (t1 == -1) {
                i++;
                if (i < j) {
                    t1 = transfer(arr[i]);
                } else {
                    return true;
                }
            }
            int t2 = transfer(arr[j]);
            while (t2 == -1) {
                j--;
                if (i < j) {
                    t2 = transfer(arr[j]);
                } else {
                    return true;
                }
            }
            if (t1 != t2) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int transfer(char t) {
        if (t < 48 ||
                (t > 57 && t < 65) ||
                (t > 90 && t < 97) ||
                (t > 122)) {
            return -1;
        }
        if (t >= 97) {
            t = (char) ((int) t - 32);
        }
        return t;
    }
}
