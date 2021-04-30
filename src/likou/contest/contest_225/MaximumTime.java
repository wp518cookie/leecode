package likou.contest.contest_225;

/**
 * @author wuping
 * @date 2021-01-24
 * https://leetcode-cn.com/contest/weekly-contest-225/problems/latest-time-by-replacing-hidden-digits/
 */

public class MaximumTime {
    public static void main(String[] args) {
        String s = "?4:03";
        System.out.println(new MaximumTime().maximumTime(s));
    }

    public String maximumTime(String time) {
        if (time == null || time.length() == 0) {
            return time;
        }
        StringBuilder sb = new StringBuilder();
        char t1 = time.charAt(0);
        char t2 = time.charAt(1);
        char t3 = time.charAt(3);
        char t4 = time.charAt(4);

        if (t1 == '?' || t2 == '?') {
            if (t1 == '?') {
                if (t2 == '?') {
                    sb.append("23");
                } else if (t2 >= '0' && t2 <= '3') {
                    sb.append("2").append(t2);
                } else {
                    sb.append("1").append(t2);
                }
            } else {
                if (t1 == '2') {
                    sb.append(t1).append('3');
                } else {
                    sb.append(t1).append('9');
                }
            }
        } else {
            sb.append(t1).append(t2);
        }

        sb.append(":");

        if (t3 == '?' || t4 == '?') {
            if (t3 == '?') {
                if (t4 == '?') {
                    sb.append("59");
                } else {
                    sb.append('5').append(t4);
                }
            } else {
                sb.append(t3).append('9');
            }
        } else {
            sb.append(t3).append(t4);
        }
        return sb.toString();
    }
}
