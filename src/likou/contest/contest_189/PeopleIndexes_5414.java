package likou.contest.contest_189;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-05-17
 */

public class PeopleIndexes_5414 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Set<Integer>> map = new HashMap();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> companies = favoriteCompanies.get(i);
            for (int j = 0; j < companies.size(); j++) {
                if (map.containsKey(companies.get(j))) {
                    map.get(companies.get(j)).add(i);
                } else {
                    Set<Integer> set = new HashSet();
                    set.add(i);
                    map.put(companies.get(j), set);
                }
            }
        }
        List<Integer> result = new ArrayList();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            List<String> companies = favoriteCompanies.get(i);
            Set<Integer> set = map.get(companies.get(0));
            boolean flag = true;
            for (int j : set) {
                if (j == i) {
                    continue;
                }
                if (ifChild(i, j, companies, map)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean ifChild(int i, int j, List<String> companies, Map<String, Set<Integer>> map) {
        for (int k = 1; k < companies.size(); k++) {
            if (!map.get(companies.get(k)).contains(j)) {
                return false;
            }
        }
        return true;
    }
}
