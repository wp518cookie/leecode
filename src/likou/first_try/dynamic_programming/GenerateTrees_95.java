package likou.first_try.dynamic_programming;

import java.util.List;

/**
 * @author wuping
 * @date 2020-04-17
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * <p>
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */

public class GenerateTrees_95 {
    public static void main(String[] args) {
        new GenerateTrees_95().generateTrees(3);
    }

    public List<TreeNode> generateTrees(int n) {
        return null;
    }

    public TreeNode generate(TreeNode root, TreeNode parent, int start, int end) {
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @author wuping
     * @date 2020-04-01
     * https://leetcode-cn.com/problems/is-subsequence/
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 示例 1:
     * s = "abc", t = "ahbgdc"
     * 返回 true.
     * 示例 2:
     * s = "axc", t = "ahbgdc"
     * false
     * https://leetcode-cn.com/problems/is-subsequence/
     *
     */

    public static class IsSubsequence_392 {
        public boolean isSubsequence(String s, String t) {
            return false;
        }
    }
}
