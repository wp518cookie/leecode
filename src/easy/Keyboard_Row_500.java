package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ping.wu on 2017/4/17.
 */
public class Keyboard_Row_500 {
    public static final int[] ALP = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            String s = words[i].toLowerCase();
            boolean flag = true;
            int temp = -1;
            for (int j = 0; j < s.length(); j++) {
                if (temp < 0) {
                    temp = ALP[s.charAt(j) - 97];
                } else {
                    if (temp != ALP[s.charAt(j) - 97]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result.add(words[i]);
            }
        }
        String[] result_arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result_arr[i] = result.get(i);
        }
        return result_arr;
    }

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(s)));
    }
}
