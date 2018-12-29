package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2018/12/29
 */

public class Unique_Binary_Search_Trees_96 {
    public static void main(String[] args) {
        numTrees(4);
    }

    public static int numTrees(int n) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        for (int i = 3; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                if (left == 0 || left == 1) {
                    count += list.get(right - 1);
                } else if (right == 0 || right == 1) {
                    count += list.get(left - 1);
                } else {
                    count += list.get(left - 1) * list.get(right - 1);
                }
            }
            list.add(count);
        }
        System.out.println(list);
        return 0;
    }
}
