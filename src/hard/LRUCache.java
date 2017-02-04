package hard;

import java.util.*;

/**
 * Created by ping.wu on 2017/2/4.
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
    int size = 0;

    public LRUCache(int capacity) {
        size = capacity;
    }

    public int get(int key) {
        Integer result = map.get(key);
        map.remove(key);
        if (result == null) {
            return -1;
        } else {
            map.put(key, result);
            return result;
        }
    }

    public void put(int key, int value) {
        if (map.size() < size) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                Set<Integer> keys = map.keySet();
                for (Integer i : keys) {
                    map.remove(i);
                    map.put(key, value);
                    return;
                }

            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
