package first.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-08-01
 */

public class Max_Depth_559 {
    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList());
        Node node2 = new Node(2, new ArrayList());
        Node node3 = new Node(3, new ArrayList());
        Node node4 = new Node(4, new ArrayList());
        Node node5 = new Node(5, new ArrayList());
        Node node6 = new Node(6, new ArrayList());
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children.add(node5);
        node3.children.add(node6);
        System.out.println(new Max_Depth_559().maxDepth(node1));
    }
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int count = 1;
        while (queue.isEmpty()) {
            int newCount = 0;
            while (count-- > 0) {
                Node t = queue.poll();
                if (t.children != null && t.children.size() > 0) {
                    for (Node n : t.children) {
                        queue.offer(n);
                    }
                    newCount = newCount + t.children.size();
                }
            }
            if (newCount > 0) {
                depth++;
                count = newCount;
            } else {
                return depth;
            }
        }
        return depth;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
