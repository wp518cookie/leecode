package first.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-01-03
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * Note:
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */

public class Open_the_Lock_752 {
    public int openLock(String[] deadends, String target) {
        Set<String> mark = new HashSet();
        Set<String> ends = new HashSet();
        for (String s : deadends) {
            ends.add(s);
        }
        if ("0000".equals(target)) {
            return 0;
        }
        if (ends.contains("0000")) {
            return -1;
        }
        mark.add("0000");
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        int result = recursion(queue, 1, mark, ends, target, 0);
        return result;
    }

    public int recursion(Queue<String> queue, int size, Set<String> mark, Set<String> ends, String target, int count) {
        while (size > 0) {
            count++;
            int newSize = 0;
            while (size-- > 0) {
                String temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int t = temp.charAt(i) - 48;
                    String s = "";
                    if (t == 9) {
                        if (i == 0) {
                            s = '0' + temp.substring(1, 4);
                        } else if (i < 3) {
                            s = temp.substring(0, i) + '0' + temp.substring(i + 1, 4);
                        } else {
                            s = temp.substring(0, 3) + '0';
                        }
                    } else {
                        if (i == 0) {
                            s = (t + 1) + temp.substring(1, 4);
                        } else if (i < 3) {
                            s = temp.substring(0, i) + (t + 1) + temp.substring(i + 1, 4);
                        } else {
                            s = temp.substring(0, 3) + (t + 1);
                        }
                    }
                    if (!mark.contains(s) && !ends.contains(s)) {
                        if (s.equals(target)) {
                            return count;
                        }
                        newSize++;
                        queue.offer(s);
                        mark.add(s);
                    }
                    if (t == 0) {
                        if (i == 0) {
                            s = '9' + temp.substring(1, 4);
                        } else if (i < 3) {
                            s = temp.substring(0, i) + '9' + temp.substring(i + 1, 4);
                        } else {
                            s = temp.substring(0, 3) + '9';
                        }
                    } else {
                        if (i == 0) {
                            s = (t - 1) + temp.substring(1, 4);
                        } else if (i < 3) {
                            s = temp.substring(0, i) + (t - 1) + temp.substring(i + 1, 4);
                        } else {
                            s = temp.substring(0, 3) + (t - 1);
                        }
                    }
                    if (!mark.contains(s) && !ends.contains(s)) {
                        if (s.equals(target)) {
                            return count;
                        }
                        newSize++;
                        queue.offer(s);
                        mark.add(s);
                    }
                }
            }
            size = newSize;
        }
        return -1;
    }
}
