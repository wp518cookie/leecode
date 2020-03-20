package likou.contest_180;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-03-15
 */

public class CustomStack_5357 {
    private LinkedList<Integer> linkedList = new LinkedList();
    int count = 0;
    int maxSize;

    public CustomStack_5357(int maxSize) {
        this.linkedList = new LinkedList();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (count < maxSize) {
            linkedList.addLast(x);
            count++;
        }
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        count--;
        return linkedList.removeLast();
    }

    public void increment(int k, int val) {
        if (k > count) {
            k = count;
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < k; i++) {
            stack.push(linkedList.removeFirst() + val);
        }
        while (!stack.isEmpty()) {
            linkedList.addFirst(stack.pop());
        }
    }

    public static void main(String[] args) {
        CustomStack_5357 t = new CustomStack_5357(2);
        t.push(1);
        t.push(2);
        t.increment(2, 1);
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
