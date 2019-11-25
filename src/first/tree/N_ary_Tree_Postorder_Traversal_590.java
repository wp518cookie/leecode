package first.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2019-10-17
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */

public class N_ary_Tree_Postorder_Traversal_590 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(0, root.val);
            if (root.children != null) {
                for (Node children : root.children) {
                    stack.push(children);
                }
            }
        }
        return result;
    }


    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
