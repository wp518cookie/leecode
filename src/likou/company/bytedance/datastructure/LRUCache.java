package likou.company.bytedance.datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wuping
 * @date 2020-06-10
 * https://leetcode-cn.com/explore/featured/card/bytedance/245/data-structure/1032/
 */

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    private int size;
    private int capacity;
    private Map<Integer, Integer> map = new HashMap();
    private Map<Integer, Integer> count = new HashMap();
    private LinkedList<Pair> listNode = new LinkedList();

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            listNode.add(new Pair(key, val));
            count.put(key, count.get(key) + 1);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            listNode.add(new Pair(key, value));
            map.put(key, value);
            count.put(key, count.get(key) + 1);
        } else {
            if (size < capacity) {
                listNode.add(new Pair(key, value));
                map.put(key, value);
                count.put(key, 1);
                size++;
            } else {
                while (true) {
                    Pair pair = listNode.removeFirst();
                    if (map.get(pair.left) == pair.right) {
                        int c = count.get(pair.left);
                        if (c == 1) {
                            map.remove(pair.left);
                            count.remove(pair.left);
                            break;
                        } else {
                            count.put(pair.left, c - 1);
                        }
                    } else {
                        count.put(pair.left, count.get(pair.left) - 1);
                    }
                }
                map.put(key, value);
                count.put(key, 1);
                listNode.add(new Pair(key, value));
            }
        }
    }

    private static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
