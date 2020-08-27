package likou.contest.contest_199;

import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-07-26
 */

public class CountPairs {
    private int count = 0;
    public int countPairs(TreeNode root, int distance) {
        return 0;
    }

    public int recursion(TreeNode t, int distance) {
        if (distance < 0) {
            return 0;
        }
        if (distance == 0) {
            if (t.left == null && t.right == null) {
                return 1;
            } else {
                return 0;
            }
        }
        if (t.left == null || t.right == null) {
            return 1;
        }
        for (int i = 0; i < distance + 1; i++) {
            int left = recursion(t, i);
            int right = recursion(t, distance - i);

        }
        return 0;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
