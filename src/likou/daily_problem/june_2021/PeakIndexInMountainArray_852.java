package likou.daily_problem.june_2021;

/**
 * @author wuping
 * @date 2021-06-15
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * <p>
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *  
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 */

public class PeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1};
        System.out.println(new PeakIndexInMountainArray_852().peakIndexInMountainArray(arr));
    }

    public int peakIndexInMountainArray(int[] arr) {
        return recursion(arr, 0, arr.length - 1);
    }

    public int recursion(int[] arr, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end + 1) >> 1;
        if (arr[mid] > arr[mid - 1]) {
            return recursion(arr, mid, end);
        } else {
            return recursion(arr, start, mid - 1);
        }
    }
}
