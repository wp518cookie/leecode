package likou.contest.contest_185;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-04-19
 * https://leetcode-cn.com/contest/weekly-contest-185/problems/minimum-number-of-frogs-croaking/
 */

public class MinNumberOfFrogs_5390 {
    public static void main(String[] args) {
        String croakOfFrogs = "ccccccccccrrccccccrcccccccccccrcccccccccrcccccccccccrcccccrcccrrcccccccccccccrocrrcccccccccrccrocccccrccccrrcccccccrrrcrrcrccrcoccroccrccccccccorocrocccrrrrcrccrcrcrcrccrcroccccrccccroorcacrkcccrrroacccrrrraocccrrcrrccorooccrocacckcrcrrrrrrkrrccrcoacrcorcrooccacorcrccccoocroacroraoaarcoorrcrcccccocrrcoccarrorccccrcraoocrrrcoaoroccooccororrrccrcrocrrcorooocorarccoccocrrrocaccrooaaarrcrarooaarrarrororrcrcckracaccorarorocacrrarorrraoacrcokcarcoccoorcrrkaocorcrcrcrooorrcrroorkkaaarkraroraraarooccrkcrcraocooaoocraoorrrccoaraocoorrcokrararrkaakaooroorcororcaorckrrooooakcarokokcoarcccroaakkrrororacrkraooacrkaraoacaraorrorrakaokrokraccaockrookrokoororoooorroaoaokccraoraraokakrookkroakkaookkooraaocakrkokoraoarrakakkakaroaaocakkarkoocokokkrcorkkoorrkraoorkokkarkakokkkracocoaaaaakaraaooraokarrakkorokkoakokakakkcracarcaoaaoaoorcaakkraooaoakkrrroaoaoaarkkarkarkrooaookkroaaarkooakarakkooaokkoorkroaaaokoarkorraoraorcokokaakkaakrkaaokaaaroarkokokkokkkoakaaookkcakkrakooaooroaaaaooaooorkakrkkakkkkaokkooaakorkaroaorkkokaakaaaaaocrrkakrooaaroroakrakrkrakaoaaakokkaaoakrkkoakocaookkakooorkakoaaaaakkokakkorakaaaaoaarkokorkakokakckckookkraooaakokrrakkrkookkaaoakaaaokkaokkaaoakarkakaakkakorkaakkakkkakaaoaakkkaoaokkkakkkoaroookakaokaakkkkkkakoaooakcokkkrrokkkkaoakckakokkocaokaakakaaakakaakakkkkrakoaokkaakkkkkokkkkkkkkrkakkokkroaakkakaoakkoakkkkkkakakakkkaakkkkakkkrkoak";
        System.out.println(new MinNumberOfFrogs_5390().minNumberOfFrogs(croakOfFrogs));
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] marked = new int[128];
        char[] arr = new char[]{'r', 'o', 'a', 'k'};
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> count = new HashMap();
        int currentIdx = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            int t = croakOfFrogs.charAt(i);
            int idx = marked[t]++;
            if (map.containsKey(idx)) {
                if (t == 'c') {
                    return -1;
                } else {
                    if (arr[map.get(idx)] != t) {
                        return -1;
                    } else {
                        if (map.get(idx) == 3) {
                            map.put(idx, i);
                            currentIdx++;
                        } else {
                            map.put(idx, map.get(idx) + 1);
                        }
                    }
                }
            } else {
                map.put(idx, 0);
                if (count.containsKey(currentIdx)) {
                    count.put(currentIdx, count.get(currentIdx) + 1);
                } else {
                    count.put(idx, 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 4) {
                return -1;
            }
        }
        int min = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            min = Math.max(entry.getValue(), min);
        }
        return min;
    }
}
