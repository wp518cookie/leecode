package geekbang.tanchao.tree;

import java.util.Stack;

/**
 * @author wuping
 * @date 2019-05-29
 */

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(10);
        TreeNode t11 = new TreeNode(11);
        TreeNode t12 = new TreeNode(12);
        TreeNode t13 = new TreeNode(13);
        TreeNode t14 = new TreeNode(14);
        TreeNode t15 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;
        t4.right = t9;
        t5.left = t10;
        t5.right = t11;
        t6.left = t12;
        t6.right = t13;
        t7.left = t14;
        t7.right = t15;
        recursionPostOrder(t1);
        System.out.println();
        interationPostOrder(t1);
    }

    public static void recursionPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        recursionPreOrder(root.left);
        recursionPreOrder(root.right);
    }

    public static void interationPreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void recursionInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursionInOrder(root.left);
        System.out.print(root.val + " ");
        recursionInOrder(root.right);
    }

    public static void interationInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public static void recursionPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursionPostOrder(root.left);
        recursionPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void interationPostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    prev = root;
                    root = null;
                } else {
                    root = temp;
                }
            }
        }
    }
}
