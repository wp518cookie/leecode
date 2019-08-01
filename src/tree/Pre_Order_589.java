package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wuping
 * @date 2019-08-01
 */

public class Pre_Order_589 {

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.children != null) {
            for (Node n : root.children) {
                preOrder(n, result);
            }
        }
        return result;
    }

    private void preOrder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.children != null) {
            for (Node n : node.children) {
                preOrder(n, result);
            }
        }
    }

    public List<Integer> preorder_iterative(Node root) {
        //todo
        return null;
    }
}
