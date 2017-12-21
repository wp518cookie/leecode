package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/10/23.
 */
public class Maximum_Product_of_Three_Numbers_628 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 100};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        int queue_count = 0;
        int negative_count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();
        PriorityQueue<Integer> negative_queue = new PriorityQueue(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1 > o2) {
                            return -1;
                        } else if (o1 < o2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
        );

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp < 0) {
                if (negative_count < 2) {
                    negative_queue.offer(temp);
                    negative_count++;
                } else {
                    if (temp < negative_queue.peek()) {
                        negative_queue.poll();
                        negative_queue.offer(temp);
                    }
                }
            }
            if (queue_count < 3) {
                queue.offer(temp);
                queue_count++;
            } else {
                if (temp > queue.peek()) {
                    queue.poll();
                    queue.offer(temp);
                }
            }
        }
        int result1 = 1;
        int result2 = 1;
        int temp = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            result2 *= temp;
        }
        if (negative_count == 2) {
            flag = true;
            result1 = negative_queue.poll() * negative_queue.poll() * temp;
        }
        if (flag) {
            return result1 > result2 ? result1 : result2;
        } else {
            return result2;
        }
    }
}
