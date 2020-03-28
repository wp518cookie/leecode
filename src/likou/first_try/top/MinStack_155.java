package likou.first_try.top;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wuping
 * @date 2020-03-28
 * https://leetcode-cn.com/problems/min-stack/
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 */

public class MinStack_155 {
    private LinkedList<Integer> stack;
    private int min = Integer.MAX_VALUE;
    public MinStack_155() {
        stack = new LinkedList();
    }

    public void push(int x) {
        if (x <= min) {
            stack.push(x);
            stack.push(x);
            min = x;
        } else {
            stack.push(x);
            stack.push(min);
        }
    }

    public void pop() {
        int t1 = stack.pop();
        int t2 = stack.pop();
        if (t1 == t2) {
            if (stack.size() > 0) {
                min = stack.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        stack.pop();
        int t2 = stack.peek();
        stack.push(min);
        return t2;
    }

    public int getMin() {
        return stack.peek();
    }
}
