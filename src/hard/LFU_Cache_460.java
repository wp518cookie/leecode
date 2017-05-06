package hard;

import java.util.*;

/**
 * Created by ping.wu on 2016/11/25.
 */
public class LFU_Cache_460 {
    private int capacity;
    private int size;
    private HashMap<Integer, Integer> cache = new HashMap();
    private HashMap<Integer, Integer> cacheCount = new HashMap();
    public static void main(String[] args) {
        LFU_Cache_460 cache = new LFU_Cache_460(10);
    }
    public LFU_Cache_460(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int temp = cache.get(key);
            cache.remove(key);
            cache.put(key, temp);
            cacheCount.put(key, cacheCount.get(key) + 1);
            return cache.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (capacity > 0) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                cacheCount.put(key, cacheCount.get(key) + 1);
                cache.put(key, value);
            } else if (size >= capacity && !cache.containsKey(key)) {
                int min_count = -1;
                int result_key = 0;
                ListIterator<Integer> cusor = new ArrayList(cache.keySet()).listIterator();
                while (cusor.hasNext()) {
                    int temp_key = cusor.next();
                    if (min_count == -1) {
                        min_count = cacheCount.get(temp_key);
                        result_key = temp_key;
                    } else {
                        if (min_count > cacheCount.get(temp_key)) {
                            min_count = cacheCount.get(temp_key);
                            result_key = temp_key;
                        }
                    }
                }
                cache.remove(result_key);
                cacheCount.remove(result_key);
                cache.put(key, value);
                cacheCount.put(key, 0);
            } else {
                cache.put(key, value);
                cacheCount.put(key, 0);
                size++;
            }
        }
    }
}
