package likou.daily_problem.july_2020;

/**
 * @author wuping
 * @date 2020-08-28
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 *
 * R    L   U   D
 */

public class JudgeCircle {

    /**
     * 执行用时：
     * 11 ms, 在所有 Java 提交中击败了15.91%的用户
     * 内存消耗：
     * 39.7 MB, 在所有 Java 提交中击败了71.38%的用户
     * @param moves
     * @return
     */
//    public boolean judgeCircle(String moves) {
//        int rCount = 0;
//        int uCount = 0;
//        for (int i = 0; i < moves.length(); i++) {
//            if (moves.charAt(i) == 'R') {
//                rCount++;
//            } else if (moves.charAt(i) == 'L') {
//                rCount--;
//            } else if (moves.charAt(i) == 'U') {
//                uCount++;
//            } else if (moves.charAt(i) == 'D') {
//                uCount--;
//            }
//        }
//        return rCount == 0 && uCount == 0;
//    }

    public boolean judgeCircle(String moves) {
        int[] mark = new int[128];
        for (int i = 0; i < moves.length(); i++) {
            mark[moves.charAt(i)]++;
        }
        if (mark['U'] != mark['D']) {
            return false;
        }
        return mark['L'] == mark['R'];
    }
}
