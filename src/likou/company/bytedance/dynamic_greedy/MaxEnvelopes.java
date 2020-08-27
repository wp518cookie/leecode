package likou.company.bytedance.dynamic_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wuping
 * @date 2020-07-02
 * https://leetcode-cn.com/explore/featured/card/bytedance/246/dynamic-programming-or-greedy/1031/
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */

public class MaxEnvelopes {
//    public int maxEnvelopes(int[][] envelopes) {
//        return -1;
//    }

    //官方解法
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
        }});

        return 0;
    }
}
