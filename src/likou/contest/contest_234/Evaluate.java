package likou.contest.contest_234;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuping
 * @date 2021-03-28
 */

public class Evaluate {
    public static void main(String[] args) {
        List<List<String>> t = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        t1.add("a");
        t1.add("yes");
        t.add(t1);

        List<String> t2 = new ArrayList<>();
        t2.add("age");
        t2.add("two");
        t.add(t2);


        System.out.println(new Evaluate().evaluate("(a)(a)(a)aaa", t));

    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap();
        if (knowledge != null && knowledge.size() > 0) {
            for (List<String> pair : knowledge) {
                map.put(pair.get(0), pair.get(1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(') {
                StringBuilder key = new StringBuilder();
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == ')') {
                        if (map.containsKey(key.toString())) {
                            sb.append(map.get(key.toString()));
                        } else {
                            sb.append("?");
                        }
                        i = j;
                        break;
                    } else {
                        key.append(s.charAt(j));
                    }
                }
            } else {
                sb.append(t);
            }
        }
        return sb.toString();
    }
}
