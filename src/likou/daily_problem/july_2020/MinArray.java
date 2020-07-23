package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-07-22
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 */

public class MinArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 1};
        System.out.println(new MinArray().minArray(arr));
    }

    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int t = numbers[mid];
            int cap = numbers[start] - numbers[end];
            if (cap < 0) {
                return numbers[start];
            } else if (cap == 0) {
                while (start < end) {
                    start++;
                    if (numbers[start] != numbers[start - 1]) {
                        break;
                    }
                }
            } else {
                int cap1 = numbers[start] - t;
                if (cap1 > 0) {
                    end = mid;
                } else if (cap1 <= 0) {
                    start = mid + 1;
                }
            }
        }
        return numbers[start];
    }
}
