package weektest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2017/2/6.
 */
public class Keyboard_Row_500 {
    public static void main(String[] args) {
        String[] s = {"a", "b"};
        findWords(s);
    }

    public static String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        int[] alphabet = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        int index = -1;
        List<String> result = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            temp = temp.toLowerCase();
            char[] temp_arr = temp.toCharArray();
            for (int j = 0; j < temp_arr.length; j++) {
                if (index == -1) {
                    index = alphabet[temp_arr[j] - 97];
                } else {
                    if (index != alphabet[temp_arr[j] - 97]) {
                        index = -1;
                        break;
                    }
                }
            }
            if (index != -1) {
                result.add(words[i]);
                index = -1;
            }
        }
        if (result.size() == 0) {
            return new String[0];
        }
        String[] result_arr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            result_arr[i] = result.get(i);
        }
        return result_arr;
    }
}
