package likou.daily_problem.june_2021;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2021-06-21
 *
 * https://leetcode-cn.com/problems/binary-watch/
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
 * 你可以 按任意顺序 返回答案。
 *
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 *
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 *
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 *
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 *  
 * 提示：
 * 0 <= turnedOn <= 10
 */

public class ReadBinaryWatch_401 {
    public static void main(String[] args) {
        List<String> result = new ReadBinaryWatch_401().readBinaryWatch(1);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> readBinaryWatch(int turnedOn) {
        // 1 2 4 8
        // 1 2 4 8 16 32

        List<String> result = new ArrayList<>();
        if (turnedOn == 10) {
            return result;
        }
        int[] hArr = new int[]{1, 2, 4, 8};
        int[] mArr = new int[]{1, 2, 4, 8, 16, 32};

        for (int i = 0; i <= turnedOn; i++) {
            List<String> hourL = new ArrayList<>();
            hourRecursion(0, 3, 0, i, hArr, hourL);
            if (hourL.size() == 0) {
                continue;
            }
            List<String> minL = new ArrayList<>();
            minRecursion(0, 5, 0, turnedOn - i, mArr, minL);
            if (minL.size() == 0) {
                continue;
            }
            for (int j = 0; j < hourL.size(); j++) {
                for (int k = 0; k < minL.size(); k++) {
                    result.add(hourL.get(j) + ":" + minL.get(k));
                }
            }
        }
        return result;
    }

    public void hourRecursion(int start, int end, int hour, int c, int[] arr, List<String> hourList) {
        if (c == 0) {
            hourList.add(String.valueOf(hour));
            return;
        }
        if (end - start + 1 < c) {
            return;
        }
        for (int i = start; i <= end; i++) {
            if (hour + arr[i] > 11) {
                return;
            }
            hourRecursion(i + 1, end, hour + arr[i], c - 1, arr, hourList);
        }
    }

    public void minRecursion(int start, int end, int min, int c, int[] arr, List<String> minList) {
        if (c == 0) {
            if (min < 10) {
                minList.add("0" + min);
            } else {
                minList.add(min + "");
            }
            return;
        }
        if (end - start + 1 < c) {
            return;
        }
        for (int i = start; i <= end; i++) {
            if (min + arr[i] > 59) {
                return;
            }
            minRecursion(i + 1, end, min + arr[i], c - 1, arr, minList);
        }
    }

    //todo 枚举的话时间复杂度更低
}
