package first.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Happy_Number_202 {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet();
        int newN = 0;
        set.add(n);
        while (n != 1) {
            while (n > 10) {
                newN += n%10 * n%10;
                n = n / 10;
            }
            newN += n * n;
            if (set.contains(newN)) {
                return false;
            }
            set.add(newN);
            n = newN;
        }
        return true;
    }
}
