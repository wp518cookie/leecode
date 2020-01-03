package first.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wuping
 * @date 2019-12-31
 */

public class N_ary_Tree_Level_Order_Traversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int size = 1;
        while (size > 0) {
            int newSize = 0;
            List<Integer> temp = new ArrayList();
            while (size-- > 0) {
                Node node = queue.poll();
                temp.add(node.val);
                if (node.children != null && node.children.size() > 0) {
                    for (Node n : node.children) {
                        queue.offer(n);
                    }
                    newSize += node.children.size();
                }
            }
            size = newSize;
            result.add(temp);
        }
        return result;
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
