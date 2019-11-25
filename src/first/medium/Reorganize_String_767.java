package first.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ping.wu on 2018/2/10.
 */
public class Reorganize_String_767 {
    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
    }
    public static String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 97]++;
        }
        PriorityQueue<SimpleObj> queue = new PriorityQueue(26, new Comparator<SimpleObj>() {
            public int compare(SimpleObj o1, SimpleObj o2) {
                return o2.times - o1.times;
            }
        });
        for (int i = 0; i < 26; i++) {
            queue.add(new SimpleObj(count[i], (char)(i + 97)));
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            SimpleObj firstObj = queue.poll();
            if (queue.isEmpty()) {
                if (firstObj.times != 0) {
                    sb.append(firstObj.alpha);
                }
                return sb.toString();
            }
            SimpleObj secondObj = queue.poll();
            if (secondObj.times > 0) {
                sb.append(firstObj.alpha).append(secondObj.alpha);
                firstObj.times--;
                secondObj.times--;
            } else {
                if (firstObj.times > 0) {
                    sb.append(firstObj.alpha);
                    firstObj.times--;
                }
            }
            if (firstObj.times > 0) {
                queue.offer(firstObj);
            }
            if (secondObj.times > 0) {
                queue.offer(secondObj);
            }
        }
        return sb.toString();
    }
    private static class SimpleObj {
        public int times;
        public char alpha;
        public SimpleObj(int times, char alpha) {
            this.times = times;
            this.alpha = alpha;
        }
    }
}
