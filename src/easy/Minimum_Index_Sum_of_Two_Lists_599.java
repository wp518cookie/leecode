package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/10/19.
 */
public class Minimum_Index_Sum_of_Two_Lists_599 {
    public static void main(String[] args) {
        String[] s1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(findRestaurant(s1, s2)));
    }
    public static String[] findRestaurant(String[] list1, String[] list2) {
        int min = list1.length + list2.length - 2;
        boolean flag = false;
        List<String> result = new ArrayList();
        for (int i = 0; i < list1.length; i++) {
            if (i > min) {
                break;
            }
            String s1 = list1[i];
            for (int j = 0; j < list2.length; j++) {
                if (j > min - i) {
                    break;
                }
                if (s1.equals(list2[j])) {
                    if (min > i + j) {
                        min = i + j;
                        result.clear();
                        result.add(s1);
                    } else if (min == i + j) {
                        result.add(s1);
                    }
                }
            }
        }
        String[] re = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            re[i] = result.get(i);
        }
        return re;
    }
}
