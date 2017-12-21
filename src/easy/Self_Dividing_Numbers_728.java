package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Self_Dividing_Numbers_728 {
    public static void main(String[] args) {
        List<Integer> result = selfDividingNumbers(1, 22);
        for (int t : result) {
            System.out.println(t);
        }
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList();
        for (int i = left; i <= right; i++) {
            int temp = i;
            boolean flag = true;
            while (temp != 0) {
                int rest = temp % 10;
                if (rest == 0) {
                    flag = false;
                    break;
                } else {
                    if (i % rest == 0) {
                        temp = temp / 10;
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }
}
