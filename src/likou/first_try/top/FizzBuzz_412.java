package likou.first_try.top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2020-04-03
 * https://leetcode-cn.com/problems/fizz-buzz/
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 */

public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        int t = 0;
        List<String> result = new ArrayList();
        for (int i = 1; i <= n; i++) {
            t++;
            if (t == 15) {
                result.add("FizzBuzz");
                t = 0;
            } else if (t % 5 == 0) {
                result.add("Buzz");
            } else if (t % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(i + "");
            }
        }
        return result;
    }
}
