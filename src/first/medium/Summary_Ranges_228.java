package first.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ping.wu on 2017/1/3.
 */
public class Summary_Ranges_228 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (start == -1) {
                start = i;
                continue;
            }
            if (nums[i] - nums[i - 1] != 1) {
                if (start == (i - 1)) {
                    sb.append(nums[start]);
                    list.add(sb.toString());
                } else {
                    sb.append(nums[start]);
                    sb.append("->").append(nums[i - 1]);
                    list.add(sb.toString());
                }
                i = i - 1;
                start = -1;
                sb = new StringBuilder();
            }
        }
        return list;
    }
}
