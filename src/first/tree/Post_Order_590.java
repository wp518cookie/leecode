package first.tree;

import java.util.List;

/**
 * @author wuping
 * @date 2019-08-01
 */

public class Post_Order_590 {
    public List<Integer> postorder(Node root) {
//        List<Integer> result = new ArrayList();
//        if (root == null) {
//            return result;
//        }
//        Stack<Node> stack = new Stack();
//        stack.add(root);
//        int count = 1;
//        while (stack.isEmpty()) {
//            Node n = stack.peek();
//            List<Node> childrens = n.children;
//
//        }
        return null;
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
