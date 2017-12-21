package medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ping.wu on 2016/12/22.
 */
public class Remove_K_Digits_402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("10012121", 2));
    }
    public static String removeKdigits(String num, int k) {
        char[] arr = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            int index = -1;
            boolean flag = true;
            for (int i = 0; i < arr.length; i++) {
                if (index == -1 && arr[i] == 'a') {
                    continue;
                } else if (index == -1 && arr[i] != 'a') {
                    if (arr[i] == '0') {
                        arr[i] = 'a';
                        continue;
                    }
                    index = i;
                    continue;
                }
                if (arr[i] == 'a') {
                    continue;
                }
                if (flag && arr[i] == '0') {
                    arr[i] = 'a';
                    break;
                } else {
                    flag = false;
                }
                if (arr[index] < arr[i]) {
                    index = i;
                    continue;
                } else if (arr[index] > arr[i]) {
                    break;
                }
            }
            if (index != -1) {
                arr[index] = 'a';
                k--;
            } else {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'a') {
                sb.append(arr[i]);
            }
        }
        return sb.toString().equals("") ? "0" : sb.toString();
    }
}
