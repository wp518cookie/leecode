package first.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-09-14
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *  
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 */

public class GenerateTrees {
    public static void main(String[] args) {
        List<TreeNode> list = new GenerateTrees().generateTrees(3);
        System.out.println(list.size());
    }

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList();
        }
        List<TreeNode> result = generateTree(1, n);
        return result;
    }

    public List<TreeNode> generateTree(int start, int end) {
        if (start > end) {
            return null;
        }
        List<TreeNode> result = new ArrayList();
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);
            if (left == null && right == null) {
                result.add(new TreeNode(i));
            } else if (left == null || right == null) {
                if (left != null) {
                    for (TreeNode t : left) {
                        TreeNode r = new TreeNode(i);
                        r.left = t;
                        result.add(r);
                    }
                } else {
                    for (TreeNode t : right) {
                        TreeNode r = new TreeNode(i);
                        r.right = t;
                        result.add(r);
                    }
                }
            } else {
                for (TreeNode t1 : left) {
                    for (TreeNode t2 : right) {
                        TreeNode t = new TreeNode(i);
                        t.left = t1;
                        t.right = t2;
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
