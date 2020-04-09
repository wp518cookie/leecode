package likou.contest_183;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author wuping
 * @date 2020-04-05
 *
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 *
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 *
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 *
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 */

public class LongestDiverseString_5195 {
    public String longestDiverseString(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap(4);
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        StringBuilder sb = new StringBuilder();
        while (true) {
            char max = findMax(map, 'd');
            if (map.get(max) == 0) {
                return sb.toString();
            }
            int rest = getRest(map, max);
            char next = findMax(map, max);
            if (max - rest > 2) {
                sb.append(max).append(max).append(next);
                map.put(max, map.get(max) - 2);
                map.put(next, map.get(next) - 1);
            } else {
                sb.append(max).append(max).append(next);
                map.put(max, map.get(max) - 2);
                map.put(next, map.get(next) - 1);
            }
        }
    }

    public char findMax(Map<Character, Integer> map, char pre) {
        int aC = map.get('a');
        int bC = map.get('b');
        int cC = map.get('c');
        if (pre == 'a') {
            return bC > cC ? 'b' : 'c';
        } else if (pre == 'b') {
            return aC > cC ? 'a' : 'c';
        } else if (pre == 'c') {
            return aC > bC ? 'a' : 'b';
        } else {
            if (aC > bC) {
                if (aC > cC) {
                    return 'a';
                } else {
                    return 'c';
                }
            } else {
                if (bC > cC) {
                    return 'b';
                } else {
                    return 'c';
                }
            }
        }
    }

    public int getRest(Map<Character, Integer> map, char max) {
        if (max == 'a') {
            return map.get('b') + map.get('c');
        } else if (max == 'c') {
            return map.get('a') + map.get('b');
        } else {
            return map.get('a') + map.get('c');
        }
    }
}
