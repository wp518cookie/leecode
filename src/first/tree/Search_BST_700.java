package first.tree;

/**
 * @author wuping
 * @date 2019-08-01
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */

public class Search_BST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        int nodeVal = root.val;
        if (nodeVal == val) {
            return root;
        } else if (nodeVal > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
