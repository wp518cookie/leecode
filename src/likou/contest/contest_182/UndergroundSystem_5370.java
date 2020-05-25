package likou.contest.contest_182;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuping
 * @date 2020-03-29
 */

public class UndergroundSystem_5370 {
    private Map<String, Set<Integer>> checkIn = new HashMap();
    private Map<String, Set<Integer>> checkOut = new HashMap();
    private Map<String, Integer> personCheckIn = new HashMap();
    private Map<String, Integer> personCheckOut = new HashMap();
    public UndergroundSystem_5370() {

    }

    public void checkIn(int id, String stationName, int t) {
        if (checkIn.containsKey(stationName)) {
            checkIn.get(stationName).add(id);
        } else {
            Set<Integer> list = new HashSet();
            list.add(id);
            checkIn.put(stationName, list);
        }
        String key = stationName + id;
        personCheckIn.put(key, t);
    }

    public void checkOut(int id, String stationName, int t) {
        if (checkOut.containsKey(stationName)) {
            checkOut.get(stationName).add(id);
        } else {
            Set<Integer> list = new HashSet();
            list.add(id);
            checkOut.put(stationName, list);
        }
        String key = stationName + id;
        personCheckOut.put(key, t);
    }

    public double getAverageTime(String startStation, String endStation) {
        Set<Integer> checkInpersons = checkIn.get(startStation);
        Set<Integer> checkOutPersons = checkOut.get(endStation);

        List<Integer> persons = new ArrayList<>();
        for (Integer i : checkInpersons) {
            if (checkOutPersons.contains(i)) {
                persons.add(i);
            }
        }
        long start = 0;
        long end = 0;
        for (int i = 0; i < persons.size(); i++) {
            Integer personId = persons.get(i);
            start += personCheckIn.get(startStation + personId);
            end += personCheckOut.get(endStation + personId);
        }
        return (end - start) / (double) persons.size();
    }
}
