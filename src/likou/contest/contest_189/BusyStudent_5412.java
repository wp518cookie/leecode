package likou.contest.contest_189;

/**
 * @author wuping
 * @date 2020-05-17
 * https://leetcode-cn.com/contest/weekly-contest-189/problems/number-of-students-doing-homework-at-a-given-time/
 */

public class BusyStudent_5412 {
    public static void main(String[] args) {
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        System.out.println(new BusyStudent_5412().busyStudent(startTime, endTime, 4));
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime > startTime[i]) {
                if (endTime[i] >= queryTime) {
                    count++;
                }
            } else if (queryTime == startTime[i]) {
                count++;
            }
        }
        return count;
    }
}
