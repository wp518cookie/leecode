package likou.contest.doubleweek.contest_27;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-30
 * https://leetcode-cn.com/contest/biweekly-contest-27/problems/course-schedule-iv/
 */

public class CheckIfPrerequisite {
    public static void main(String[] args) {
        int[][] t1 = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        int[][] t2 = new int[][]{{0,4},{4,0},{1,3},{3,0}};
        System.out.println(new CheckIfPrerequisite().checkIfPrerequisite(5, t1, t2));
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        if (prerequisites.length == 0) {
            for (int i = 0; i < queries.length; i++) {
                result.add(false);
            }
            return result;
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < prerequisites.length; i++) {
            int[] t = prerequisites[i];
            if (arr[t[1]] == null) {
                arr[t[1]] = new int[n];
                arr[t[1]][t[0]] = 1;
            } else {
                arr[t[1]][t[0]] = 1;
            }
        }
        Set<Integer>[] mark = new HashSet[n];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    recursion(arr, j, i, mark);
                    if (mark[i] == null) {
                        mark[i] = new HashSet();
                        mark[i].add(j);
                    } else {
                        mark[i].add(j);
                    }
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int pre = queries[i][0];
            int course = queries[i][1];
            if (arr[course] == null) {
                result.add(false);
            } else {
                result.add(arr[course] != null && arr[course][pre] == 1);
            }
        }
        return result;
    }

    public void recursion(int[][] arr, int pre, int course, Set<Integer>[] mark) {
        if (arr[pre] == null || (mark[course] != null && mark[course].contains(pre))) {
            return;
        }
        for (int i = 0; i < arr[pre].length; i++) {
            if (arr[pre][i] == 1) {
                arr[course][i] = 1;
                recursion(arr, i, course, mark);
                if (mark[course] == null) {
                    mark[course] = new HashSet();
                    mark[course].add(i);
                } else {
                    mark[course].add(i);
                }
            }
        }
    }
}
