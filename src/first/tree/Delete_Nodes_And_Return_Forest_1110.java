package first.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2019-12-12
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 */

public class Delete_Nodes_And_Return_Forest_1110 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<TreeNode> result = new ArrayList();

    public static void main(String[] args) {
        Delete_Nodes_And_Return_Forest_1110 t = new Delete_Nodes_And_Return_Forest_1110();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        int[] to_delte = new int[]{3, 5};
        t.delNodes(t1, to_delte);
        for (TreeNode temp : result) {
            System.out.println(temp.val);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return result;
        }
        Set<Integer> deleteSet = new HashSet();
        for (int i : to_delete) {
            deleteSet.add(i);
        }
        TreeNode temp = dfs(root, null, deleteSet);
        if (temp != null) {
            result.add(temp);
        }
        return result;
    }

    private TreeNode dfs(TreeNode node, TreeNode parent, Set<Integer> deleteSet) {
        if (node == null) {
            return null;
        }
        if (deleteSet.contains(node.val)) {
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            TreeNode temp;
            if ((temp = dfs(node.left, null, deleteSet)) != null) {
                result.add(temp);
            }
            if ((temp = dfs(node.right, null, deleteSet)) != null) {
                result.add(temp);
            }
            return null;
        } else {
            dfs(node.left, node, deleteSet);
            dfs(node.right, node, deleteSet);
            if (parent == null) {
                return node;
            } else {
                return null;
            }
        }
    }
}
