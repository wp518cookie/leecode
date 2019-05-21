package geekbang.tanchao.queue_and_stack;

import java.util.Stack;

/**
 * @author wuping
 * @date 2019-05-14
 */

public class MyQueue {
    private Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        Stack<Integer> temp = new Stack();
        while (stack.size() > 0) {
            temp.add(stack.pop());
        }
        stack.push(x);
        while (temp.size() > 0) {
            stack.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.size() == 0;
    }
}
