package likou.daily_problem.july_2020.sep_20;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-09-23
 */

public class TreeNodeBuild {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        TreeNode t = new TreeNodeBuild().build(arr);
        System.out.println(123);
    }

    public TreeNode build(int[] arr) {
        int idx = 0;
        TreeNode t = new TreeNode(arr[idx++]);
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(t);
        while (idx < arr.length) {
            TreeNode temp = linkedList.removeFirst();
            temp.left = new TreeNode(arr[idx++]);
            linkedList.addLast(temp.left);
            if (idx < arr.length) {
                temp.right = new TreeNode(arr[idx++]);
                linkedList.addLast(temp.right);
            }
        }
        return t;
    }
}
