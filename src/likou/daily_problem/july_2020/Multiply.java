package likou.daily_problem.july_2020;

import java.util.LinkedList;

/**
 * @author wuping
 * @date 2020-08-13
 * https://leetcode-cn.com/problems/multiply-strings/
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

public class Multiply {
    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("237", "284"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.equals("0") || num2 == null || num2.equals("0")) {
            return "0";
        }
        LinkedList<Integer>[] list = new LinkedList[num2.length()];
        int count = 0;
        int bit = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int t1 = num2.charAt(i) - '0';
            LinkedList<Integer> tList = new LinkedList<>();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int t2 = num1.charAt(j) - '0';
                int val = t1 * t2 + bit;
                bit = 0;
                if (val >= 10) {
                    bit = val / 10;
                    val = val % 10;
                }
                tList.addFirst(val);
            }
            if (bit > 0) {
                tList.addFirst(bit);
                bit = 0;
            }
            for (int j = 0; j < count; j++) {
                tList.addLast(0);
            }
            list[count++] = tList;
        }
        StringBuilder sb = new StringBuilder();
        if (list.length == 1) {
            for (int t : list[0]) {
                sb.append(t);
            }
            return sb.toString();
        }
        LinkedList<Integer> first = list[0];
        for (int i = 1; i < list.length; i++) {
            LinkedList<Integer> current = new LinkedList();
            LinkedList<Integer> second = list[i];
            boolean flag = false;
            while (first.size() > 0 && second.size() > 0) {
                int val = first.removeLast() + second.removeLast() + (flag ? 1 : 0);
                if (val >= 10) {
                    flag = true;
                    val = val % 10;
                } else {
                    flag = false;
                }
                current.addFirst(val);
            }
            while (first.size() > 0) {
                int val = first.removeLast() + (flag ? 1 : 0);
                if (val >= 10) {
                    flag = true;
                    val = val % 10;
                } else {
                    flag = false;
                }
                current.addFirst(val);
            }
            while (second.size() > 0) {
                int val = second.removeLast() + (flag ? 1 : 0);
                if (val >= 10) {
                    flag = true;
                    val = val % 10;
                } else {
                    flag = false;
                }
                current.addFirst(val);
            }
            if (flag) {
                current.addFirst(1);
            }
            first = current;
        }
        for (int t : first) {
            sb.append(t);
        }
        return sb.toString();
    }
}
