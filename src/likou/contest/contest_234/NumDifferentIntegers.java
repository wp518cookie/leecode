package likou.contest.contest_234;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuping
 * @date 2021-03-28
 * https://leetcode-cn.com/contest/weekly-contest-234/problems/number-of-different-integers-in-a-string/
 */

public class NumDifferentIntegers {
    public static void main(String[] args) {
        String word = "a1b01c001";
        System.out.println(new NumDifferentIntegers().numDifferentIntegers(word));
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (ifLowerCase(word.charAt(i))) {
                if (s.length() > 0) {
                    set.add(s.toString());
                    s = new StringBuilder();
                }
            } else {
                s.append(word.charAt(i));
            }
        }
        if (s.length() > 0) {
            set.add(s.toString());
        }
        return removeZero(set).size();
    }

    private boolean ifLowerCase(char t) {
        return t >= 'a' && t <= 'z';
    }

    private Set<String> removeZero(Set<String> set) {
        Set<String> updated = new HashSet();
        for (String t : set) {
            int idx = t.indexOf('0');
            if (idx < 0) {
                updated.add(t);
            } else {
                if (idx != 0) {
                    updated.add(t);
                } else {
                    for (int i = 0; i < t.length(); i++) {
                        if (t.charAt(i) == '0') {
                            if (i == t.length() - 1) {
                                updated.add("0");
                            }
                            continue;
                        } else {
                            updated.add(t.substring(i));
                            break;
                        }
                    }
                }
            }
        }
        return updated;
    }
}
