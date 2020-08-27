package likou.card.top_interview_questions_medium.tree;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-08-21
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvijdh/
 */

public class Connect {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：
     * 3 ms, 在所有 Java 提交中击败了45.89%的用户
     * 内存消耗：
     * 40.1 MB, 在所有 Java 提交中击败了39.00%的用户
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        LinkedList<Node> list = new LinkedList();
        list.add(root);
        while (list.size() > 0) {
            int size = list.size();
            while (size > 0) {
                size--;
                Node node = list.removeFirst();
                if (size > 0) {
                    node.next = list.peekFirst();
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
