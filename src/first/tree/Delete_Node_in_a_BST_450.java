package first.tree;

import java.util.HashMap;

/**
 * Created by ping.wu on 2016/11/30.
 */

public class Delete_Node_in_a_BST_450 {
    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode6.right = treeNode7;
//        HashMap hashMap = findNode(treeNode5, 3);
//        System.out.println(hashMap);
    }

    public static HashMap<String, TreeNode> deleteNode(TreeNode root, int key) {
        return null;
    }

    public static HashMap<String, TreeNode> findNode(TreeNode preNode,TreeNode currentNode, int key) {
        /*HashMap<String, TreeNode> result_map = new HashMap<>();
        TreeNode treeNode = map.get("current");
        if (treeNode == null) {
            return null;
        } else {
            if (key < treeNode.val) {
                result_map.put("current", treeNode.left);
                result_map.put("pre", treeNode);
                return findNode(result_map, key);
            } else if (key > treeNode.val) {
                result_map.put("current", treeNode.right);
                result_map.put("pre", treeNode);
                return findNode(result_map, key);
            } else {
                return map;
            }
        }*/
        return null;
    }

    public static int findMin_Del(TreeNode preNode, TreeNode treeNode) {
        if (treeNode.left == null) {
            preNode.left = null;
            return treeNode.val;
        } else {
            return findMin_Del(treeNode, treeNode.left);
        }
    }
}
