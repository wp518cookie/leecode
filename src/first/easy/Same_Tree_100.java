package first.easy;

/**
 * Created by ping.wu on 2017/1/10.
 */

public class Same_Tree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q !=null) || (p != null && q == null)) {
            return false;
        }
        if ((p.left == null && q.left != null) || (p.left != null && q.left == null)
                || (p.right == null && q.right != null) || (p.right != null && q.right == null)) {
            return false;
        } else {
            return p.val == q.val  && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
