package first.tree;

/**
 * @author wuping
 * @date 2019-11-25
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *  https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode root = new Convert_Sorted_Array_to_Binary_Search_Tree_108().sortedArrayToBST(nums);
        System.out.println(root.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, start, mid - 1);
        root.right = recursion(nums, mid + 1, end);
        return root;
    }

    public TreeNode recursion(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            int mid = start + ((end - start) >> 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = recursion(nums, start, mid - 1);
            root.right = recursion(nums, mid + 1, end);
            return root;
        }
    }
}
