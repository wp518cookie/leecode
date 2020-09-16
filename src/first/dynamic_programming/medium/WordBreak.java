package first.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-09-14
 * https://leetcode-cn.com/problems/word-break/
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */

public class WordBreak {
    public static void main(String[] args) {
        String[] arr = new String[]{"apple", "pen"};
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList(arr)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        CNode root = new CNode();
        for (int i = 0; i < wordDict.size(); i++) {
            String t = wordDict.get(i);
            recursion(root, 0, t);
        }
        return recursionCheck(root, root, 0, s);
    }

    private boolean recursionCheck(CNode root, CNode cur, int i, String s) {
        int idx = s.charAt(i);
        CNode cnode = cur.mark[idx];
        if (cnode == null) {
            return false;
        }
        if (i == s.length() - 1) {
            return cnode.flag;
        }
        if (cnode.flag) {
            return recursionCheck(root, cnode, i + 1, s) || recursionCheck(root, root, i + 1, s);
        } else {
            return recursionCheck(root, cnode, i + 1, s);
        }
    }

    private void recursion(CNode root, int i, String t) {
        int idx = t.charAt(i);
        if (root.mark[idx] == null) {
            root.mark[idx] = new CNode();
        }
        if (i == t.length() - 1) {
            root.mark[idx].flag = true;
            return;
        }
        recursion(root.mark[idx], i + 1, t);
    }

    private static class CNode {
        private CNode[] mark;
        private boolean flag;

        public CNode() {
            mark = new CNode[128];
            flag = false;
        }
    }
}
