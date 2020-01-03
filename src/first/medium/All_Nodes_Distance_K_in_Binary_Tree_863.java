package first.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-01-03
 */

public class All_Nodes_Distance_K_in_Binary_Tree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> map = new HashMap();
        recursion(root, null, map);
        Set<Integer> mark = new HashSet();
        List<Integer> result = new ArrayList();
        mark.add(target.val);
        recursion1(target.val, map, 0, K, mark, result);
        return result;
    }

    private void recursion1(Integer cur, Map<Integer, List<Integer>> map, Integer distance, int K, Set<Integer> mark, List<Integer> result) {
        if (distance == K) {
            result.add(cur);
            return;
        }
        List<Integer> list = map.get(cur);
        for (int t : list) {
            if (!mark.contains(t)) {
                mark.add(t);
                recursion1(t, map, distance + 1, K, mark, result);
            }
        }
    }

    private void recursion(TreeNode root, Integer parent, Map<Integer, List<Integer>> map) {
        List<Integer> list = new ArrayList();
        if (parent != null) {
            list.add(parent);
        }
        map.put(root.val, list);
        if (root.left != null) {
            list.add(root.left.val);
            recursion(root.left, root.val, map);
        }
        if (root.right != null) {
            list.add(root.right.val);
            recursion(root.right, root.val, map);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
