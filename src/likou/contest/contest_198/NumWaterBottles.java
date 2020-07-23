package likou.contest.contest_198;

/**
 * @author wuping
 * @date 2020-07-19
 */

public class NumWaterBottles {
    public static void main(String[] args) {
        System.out.println(new NumWaterBottles().numWaterBottles(9, 3));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        }
        int current = numBottles;
        int count = numBottles;
        while (current >= numExchange) {
            int t = current / numExchange;
            count += t;
            current = current % numExchange + t;
        }
        return count;
    }
}
