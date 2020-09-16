package likou.card.top_interview_questions_medium.design;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-09-11
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xwxa3m/
 */

public class Codec {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t4.left = t6;
        t4.right = t7;
        System.out.println(new Codec().serialize(t1));
        TreeNode result = new Codec().deserialize("1,2,3,n,n,4,5,6,7,n,n");
        System.out.println(123);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        boolean continueFlag = true;
        while (continueFlag && list.size() > 0) {
            int size = list.size();
            continueFlag = false;
            while (size-- > 0) {
                TreeNode t = list.removeFirst();
                if (t == null) {
                    sb.append('n');
                    sb.append(',');
                } else {
                    sb.append(t.val);
                    sb.append(',');
                    list.add(t.left);
                    list.add(t.right);
                    continueFlag = (t.left != null || t.right != null) || continueFlag;
                }
            }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        int i = 1;
        while (i < arr.length) {
            String t1 = arr[i++];
            String t2 = arr[i++];
            TreeNode t = list.removeFirst();
            if (t1.equals("n")) {
                t.left = null;
            } else {
                t.left = new TreeNode(Integer.valueOf(t1));
                list.add(t.left);
            }
            if (t2.equals("n")) {
                t.right = null;
            } else {
                t.right = new TreeNode(Integer.valueOf(t2));
                list.add(t.right);
            }
        }
        return root;
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
