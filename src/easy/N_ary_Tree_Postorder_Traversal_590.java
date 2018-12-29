//package easy;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedHashMap;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author wuping
// * @date 2018/11/21
// */
//
//public class N_ary_Tree_Postorder_Traversal_590 {
//    public List<Integer> postorder(Node root) {
//        LinkedList<Node> t = new LinkedList();
//        List<Node> current = Arrays.asList(root);
//        while (!current.isEmpty()) {
//            for (int i = 0 ; i < current.size(); i++) {
//                t.add(current.get(i));
//
//            }
//        }
//    }
//
//    class Node {
//        public int val;
//        public List<Node> children;
//
//        public Node() {}
//
//        public Node(int _val,List<Node> _children) {
//            val = _val;
//            children = _children;
//        }
//    };
//}
