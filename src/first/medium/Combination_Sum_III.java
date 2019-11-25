package first.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/8.
 */
public class Combination_Sum_III {
    public static void main(String[] args) {
        combinationSum3(3, 8);
    }


    public static List<List<Integer>> combinationSum3(Integer k, int n) {
        List<List<Integer>> lists1 = new ArrayList();
        int i = 1;
        while (i < n / k) {
            List<List<Integer>> lists = new ArrayList();
            List<Integer> list = new ArrayList();
            System.out.println(combinationSum3(k, n, i, list, lists));
            i++;
        }
        return lists1;
    }

    public static List<List<Integer>> combinationSum3(int k, int n, int start, List<
            Integer> list, List<List<Integer>> result) {
        for (int i = start; i <= n / k; i++) {
            if (i != n - i) {
                list.add(i);
                if (k > 2) {
                    combinationSum3(k - 1, n - i, i + 1, new ArrayList(list), result);
                } else {
                    list.add(n - i);
                    result.add(list);

                }
            }
        }
        return result;
    }
}
