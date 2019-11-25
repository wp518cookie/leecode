package first.easy;

/**
 * @author wuping
 * @date 2019-11-06
 * https://leetcode.com/problems/last-stone-weight/
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the first.array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the first.array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the first.array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the first.array converts to [1] then that's the value of last stone.
 */

public class Last_Stone_Weight_1046 {
    public static void main(String[] args) {
        int[] temp = {2,7,4,1,8,1};
        System.out.println(new Last_Stone_Weight_1046().lastStoneWeight(temp));
    }

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int[] heap = new int[stones.length + 1];
        int size = 1;
        for (int i = 0; i < stones.length; i++) {
            insert(heap, stones[i], size);
            size++;
        }
        int result = 0;
        while (size > 2) {
            int first = pop(heap, size--);
            int second = pop(heap, size--);
            if (first > second) {
                int temp = first - second;
                insert(heap, temp, size);
                size++;
            } else {
                int temp = second - first;
                insert(heap, temp, size);
                size++;
            }
        }
        return heap[1];
    }

    public void insert(int[] heap, int stone, int size) {
        int idx = size;
        for (; (idx >> 1) > 0 && heap[idx >> 1] < stone; idx = idx >> 1) {
            heap[idx] = heap[idx >> 1];
        }
        heap[idx] = stone;
    }

    public Integer pop(int[] heap, int size) {
        int result = heap[1];
        int last = heap[size - 1];
        int idx = 1;
        for (; (idx << 1) < size - 1;) {
            int child = idx << 1;
            if (child + 1 < size - 1 && heap[child] < heap[child + 1]) {
                child = child + 1;
            }
            if (heap[child] > last) {
                heap[idx] = heap[child];
                idx = child;
            } else {
                break;
            }
        }
        heap[idx] = last;
        return result;
    }
}
