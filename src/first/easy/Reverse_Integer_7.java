package first.easy;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2018/9/27
 */

public class Reverse_Integer_7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean digitFlag = x >= 0;
        if (!digitFlag) {
            x = x * (-1);
        }
        LinkedList<Integer> stack = new LinkedList();
        while (x != 0) {
            int t = x % 10;
            stack.push(t);
            x = x / 10;
        }
        long result = 0;
        long t = 1;
        while (!stack.isEmpty()) {
            long add = stack.pop() * t;
            result = result + add;
            t = t * 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        } else {
            if (digitFlag) {
                return (int) result;
            } else {
                result = result * (-1);
                if (result < Integer.MIN_VALUE) {
                    return 0;
                } else {
                    return (int) result;
                }
            }
        }
    }
}
