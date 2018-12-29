package easy;

import java.util.List;

/**
 * @author wuping
 * @date 2018/11/21
 */

public class N_ary_Tree_Preorder_Traversal_589 {
    public List<Integer> preorder(Node root) {
        return null;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
