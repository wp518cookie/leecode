package first.easy;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/11/30.
 */
public class Baseball_Game_682 {
    public static void main(String[] args) {
        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        LinkedList<Integer> inputStack = new LinkedList();
        int sum = 0;
        inputStack.push(Integer.valueOf(ops[0]));
        sum = Integer.valueOf(ops[0]);
        for (int i = 1; i < ops.length; i++) {
            String temp = ops[i];
            if ("C".equals(temp)) {
                int cancelItem = inputStack.pop();
                sum = sum - cancelItem;
            } else if ("D".equals(temp)) {
                int doubleItem = inputStack.peek() * 2;
                inputStack.push(doubleItem);
                sum += doubleItem;
            } else if ("+".equals(temp)) {
                int addItem1 = inputStack.pop();
                int addItem2 = inputStack.pop();
                int newItem = addItem1 + addItem2;
                sum += newItem;
                inputStack.push(addItem2);
                inputStack.push(addItem1);
                inputStack.push(newItem);
            } else {
                inputStack.push(Integer.valueOf(temp));
                sum += Integer.valueOf(temp);
            }
        }
        return sum;
    }
}
