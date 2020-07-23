package likou.company.bytedance.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author wuping
 * @date 2020-07-20
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * https://leetcode-cn.com/explore/featured/card/bytedance/243/array-and-sorting/1047/
 */

public class Trap {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Trap().trap(arr));
    }

    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        return -1;
    }
}
