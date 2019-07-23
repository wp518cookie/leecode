package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuping
 * @date 2019-07-23
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 */

public class Maximize_Distance_to_Closest_Person_849 {
    public static void main(String[] args) {
        System.out.println(new Maximize_Distance_to_Closest_Person_849().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length < 2) {
            return 0;
        }
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                count++;
            } else {
                if (count > 0) {
                    if (i - count == 0) {
                        maxCount = Math.max(maxCount, count);
                    } else {
                        maxCount = Math.max(maxCount, (count - 1) / 2 + 1);
                    }
                }
                count = 0;
            }
        }
        if (count > 0) {
            maxCount = Math.max(maxCount, count);
        }
        return maxCount ;
    }
}
