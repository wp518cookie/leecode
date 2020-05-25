package likou.contest.contest_190;

/**
 * @author wuping
 * @date 2020-05-24
 */

public class PseudoPalindromicPaths_5418 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(1);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t4.left = t5;
        t4.right = t6;
        t5.right = t7;
        t7.right = t9;
        t6.right = t8;

        System.out.println(new PseudoPalindromicPaths_5418().pseudoPalindromicPaths(t1));
    }

    private int result = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        if (root.left == null && root.right == null) {
            return 1;
        }
        recursion(root, count);
        return result;
    }

    private void recursion(TreeNode root, int[] count) {
        count[root.val] ++;
        if (root.left == null && root.right == null) {
            if (check(count)) {
                result++;
            }
            count[root.val]--;
            return;
        }
        if (root.left != null) {
            recursion(root.left, count);
        }
        if (root.right != null) {
            recursion(root.right, count);
        }
        count[root.val]--;
    }

    private boolean check(int[] count) {
        int oddNum = 0;
        for (int i = 1; i <= 9; i++) {
            if (count[i] % 2 != 0) {
                oddNum++;
            }
            if (oddNum > 1) {
                return false;
            }
        }
        return true;
    }

    public static class TreeNode {
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
