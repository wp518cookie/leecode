package first.hashtable;

/**
 * @author wuping
 * @date 2019-07-26
 */

public class Repeated_NTimes_961 {
    public int repeatedNTimes(int[] A) {
        int[] mark = new int[10001];
        for (int t : A) {
            mark[t]++;
        }
        int compared = A.length / 2;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == compared) {
                return i;
            }
        }
        return -1;
    }
}
