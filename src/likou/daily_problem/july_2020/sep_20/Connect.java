package likou.daily_problem.july_2020.sep_20;

/**
 * @author wuping
 * @date 2020-09-28
 * 给定一个二叉树
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 */

public class Connect {
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

    ;

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n3.right = n5;
        Node result = new Connect().connect(root);
        System.out.println(123);
    }

    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left != null) {
            root.left.next = root.right;
            recursion(root.left);
        } else {
            recursion(root.right);
        }
        return root;
    }

    public Node recursion(Node root) {
        if (root == null) {
            return null;
        }
        Node first = null;
        Node pre = null;
        while (root != null) {
            if (root.left == null && root.right == null) {
                root = root.next;
                continue;
            } else if (root.left == null || root.right == null) {
                if (first == null) {
                    pre = root.left == null ? root.right : root.left;
                }
                if (pre == null) {
                    pre = root.left == null ? root.right : root.left;
                    root = root.next;
                    continue;
                }
                if (root.left == null) {
                    pre.next = root.right;
                    pre = pre.next;
                } else {
                    pre.next = root.left;
                    pre = pre.next;
                }
                root = root.next;
            } else {
                if (first == null) {
                    first = root.left;
                }
                if (pre == null) {
                    root.left.next = root.right;
                    pre = root.right;
                    root = root.next;
                } else {
                    pre.next = root.left;
                    root.left.next = root.right;
                    pre = root.right;
                    root = root.next;
                }
            }
        }
        recursion(first);
        return first;
    }
}
