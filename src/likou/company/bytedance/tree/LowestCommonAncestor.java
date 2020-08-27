package likou.company.bytedance.tree;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-06-23
 * https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1026/
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        return root;
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return null;
//        }
//        Map<Integer, Map<Integer, TreeNode>> pMap = new TreeMap((a, b) -> ((int) b - (int) a));
//        recursion(0, root, p, pMap);
//        Map<Integer, Map<Integer, TreeNode>> qMap = new TreeMap<>((a, b) -> ((int) b - (int) a));
//        recursion(0, root, q, qMap);
//        List<Integer> depthList = new ArrayList();
//        for (Integer key : pMap.keySet()) {
//            depthList.add(key);
//        }
//        for (int i = 0; i < depthList.size(); i++) {
//            int depth = depthList.get(i);
//            Map<Integer, TreeNode> pVal = pMap.get(depth);
//            Map<Integer, TreeNode> qVal = qMap.get(depth);
//            if (pVal == null || qVal == null) {
//                continue;
//            }
//            for (Integer key : pVal.keySet()) {
//                if (qVal.containsKey(key)) {
//                    return qVal.get(key);
//                }
//            }
//        }
//        return root;
//    }
//
//    private boolean recursion(int depth, TreeNode t, TreeNode find, Map<Integer, Map<Integer,TreeNode>> map) {
//        if (t == null) {
//            return false;
//        }
//        if (t.val == find.val) {
//            addToMap(depth, t, map);
//            return true;
//        }
//        if (recursion(depth + 1, t.left, find, map)) {
//            addToMap(depth, t, map);
//            return true;
//        }
//        if (recursion(depth + 1, t.right, find, map)) {
//            addToMap(depth, t, map);
//            return true;
//        }
//        return false;
//    }
//
//    private void addToMap(int depth, TreeNode t, Map<Integer, Map<Integer, TreeNode>> map) {
//        if (map.containsKey(depth)) {
//            map.get(depth).put(t.val, t);
//        } else {
//            Map<Integer, TreeNode> temp = new HashMap();
//            temp.put(t.val, t);
//            map.put(depth, temp);
//        }
//    }

    //    /**
//     * 执行用时：17 ms
//     * 内存消耗：42.6 MB
//     * @param root
//     * @param p
//     * @param q
//     * @return
//     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<Pair> t1 = new ArrayList();
//        List<Pair> t2 = new ArrayList();
//        recursion(root, p, 0, t1);
//        recursion(root, q, 0, t2);
//        t1.sort((a, b) -> b.depth - a.depth);
//        t2.sort((a, b) -> b.depth - a.depth);
//        LinkedHashMap<Integer, List<TreeNode>> map = new LinkedHashMap<>();
//        for (int i = 0; i < t2.size(); i++) {
//            Pair pair = t2.get(i);
//            if (map.containsKey(pair.depth)) {
//                map.get(pair.depth).add(pair.treeNode);
//            } else {
//                List<TreeNode> lists = new ArrayList();
//                lists.add(pair.treeNode);
//                map.put(pair.depth, lists);
//            }
//        }
//        for (int i = 0; i < t1.size(); i++) {
//            Pair pair = t1.get(i);
//            if (!map.containsKey(pair.depth)) {
//                continue;
//            } else {
//                List<TreeNode> temp = map.get(pair.depth);
//                for (TreeNode t : temp) {
//                    if (t == pair.treeNode) {
//                        return t;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    public boolean recursion(TreeNode t, TreeNode p, int depth, List<Pair> record) {
//        if (t == null) {
//            return false;
//        }
//        if (t.val == p.val) {
//            record.add(new Pair(depth, t));
//            return true;
//        }
//        if (recursion(t.left, p, depth + 1, record) || recursion(t.right, p, depth + 1, record)) {
//            record.add(new Pair(depth, t));
//            return true;
//        }
//        return false;
//    }
//
//    private static class Pair {
//        int depth;
//        TreeNode treeNode;
//
//        public Pair(int depth, TreeNode treeNode) {
//            this.depth = depth;
//            this.treeNode = treeNode;
//        }
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
