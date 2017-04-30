package weektest;

import java.util.*;

/**
 * Created by ping.wu on 2017/2/6.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Most_Frequent_Subtree_Sum_508 {
    private static List<Integer> result;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        node1.left = node2;
//        TreeNode node3 = new TreeNode(-5);
//        node1.right = node3;
        Most_Frequent_Subtree_Sum_508 most_frequent_subtree_sum_508 = new Most_Frequent_Subtree_Sum_508();
        int[] result1 = most_frequent_subtree_sum_508.findFrequentTreeSum(node1);
        for (int i : result1) {
            System.out.println(i);
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        result = new ArrayList();
        addNodeValue(root);
        Map<Integer, Integer> temp = new HashMap();
        for (int i = 0; i < result.size(); i++) {
            if (temp.containsKey(result.get(i))) {
                int count = temp.get(result.get(i));
                temp.put(result.get(i), count + 1);
            } else {
                temp.put(result.get(i), 1);
            }
        }
        int max = -1;
        List<Integer> t_result = new ArrayList();
        for (Integer keys : temp.keySet()) {
            if (temp.get(keys) > max) {
                t_result = new ArrayList();
                t_result.add(keys);
                max = temp.get(keys);
            } else if (temp.get(keys) == max) {
                t_result.add(keys);
            }
        }
        int[] final_result = new int[t_result.size()];
        for (int i = 0; i < t_result.size(); i++) {
            final_result[i] = t_result.get(i);
        }
        return final_result;
//        return t_result.stream().mapToInt(i->i).toArray();
    }

    public void addNodeValue(TreeNode root) {
        if (root != null) {
            result.add(sumSubTreeNode(root));
        }
        if (root.left != null) {
            addNodeValue(root.left);
        }
        if (root.right != null) {
            addNodeValue(root.right);
        }
    }

    public int sumSubTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else if (treeNode.left != null && treeNode.right != null) {
            return treeNode.val + sumSubTreeNode(treeNode.left) + sumSubTreeNode(treeNode.right);
        } else if (treeNode.left == null && treeNode.right == null) {
            return treeNode.val;
        } else if (treeNode.left == null && treeNode.right != null) {
            return treeNode.val + sumSubTreeNode(treeNode.right);
        } else {
            return treeNode.val + sumSubTreeNode(treeNode.left);
        }
    }
}

