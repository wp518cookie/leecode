package first.hashtable;

/**
 * @author wuping
 * @date 2019-07-26
 * https://leetcode.com/problems/design-hashset/
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */

public class My_Hash_Set_705 {
    boolean[] mark;
    public My_Hash_Set_705() {
        mark = new boolean[1000001];
    }

    public void add(int key) {
        mark[key] = true;
    }

    public void remove(int key) {
        mark[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return mark[key];
    }
}
