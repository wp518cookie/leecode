package first.array;

/**
 * @author wuping
 * @date 2019-07-23
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 */

public class Num_Pairs_Divisible_By_60_1010 {
    public static void main(String[] args) {
        int[] time = new int[]{269,230,318,468,171,158,350,60,287,27,11,384,332,267,412,478,280,303,242,378,129,131,164,467,345,146,264,332,276,479,284,433,117,197,430,203,100,280,145,287,91,157,5,475,288,146,370,199,81,428,278,2,400,23,470,242,411,470,330,144,189,204,62,318,475,24,457,83,204,322,250,478,186,467,350,171,119,245,399,112,252,201,324,317,293,44,295,14,379,382,137,280,265,78,38,323,347,499,238,110,18,224,473,289,198,106,256,279,275,349,210,498,201,175,472,461,116,144,9,221,473};
        System.out.println(new Num_Pairs_Divisible_By_60_1010().numPairsDivisibleBy60(time));
    }
    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length < 2) {
            return 0;
        }
        int result = 0;
        int[] count = new int[501];
        for (int i = 0; i < time.length; i++) {
            count[time[i]]++;
        }
        for (int i = 1; i < 1000; i++) {
            if (i % 60 == 0) {
                int j = 1;
                if (i > 500) {
                    j = i - 500;
                }
                for (; j < (i / 2); j++) {
                    int t = Math.min(count[j], count[i - j]);
                    if (t > 0) {
                        result += count[j] * count[i - j];
                    }
                }
                if (count[i / 2] > 1) {
                     result = result + (count[i / 2] * (count[i / 2] - 1) / 2);
                }
            }
        }
        return result;
    }
}
