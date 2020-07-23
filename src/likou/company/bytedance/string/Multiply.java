package likou.company.bytedance.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-06-19
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1015/
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

public class Multiply {
//    public static void main(String[] args) {
//        System.out.println(new Multiply().multiply("9133", "123"));
//    }

//    public String multiply(String num1, String num2) {
//
//    }

    // low版本
//    public String multiply(String num1, String num2) {
//        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
//            return "0";
//        }
//        if (num1.equals("0") || num2.equals("0")) {
//            return "0";
//        }
//        if (num1.length() < num2.length()) {
//            String temp = num1;
//            num1 = num2;
//            num2 = temp;
//        }
//        List<String> list = new ArrayList<>();
//        int zeroCount = 0;
//        for (int i = num2.length() - 1; i >= 0; i--) {
//            list.add(countPer(num1, num2.charAt(i), zeroCount++));
//        }
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        String result = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            result = add(result, list.get(i));
//        }
//        return result;
//    }
//
//    public String add(String a, String b) {
//        boolean flag = false;
//        int count = a.length() > b.length() ? b.length() : a.length();
//        int i = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i < count) {
//            int t1 = a.charAt(a.length() - 1 - i) - '0';
//            int t2 = b.charAt(b.length() - 1 - i) - '0';
//            int temp = t1 + t2 + (flag ? 1 : 0);
//            if (temp >= 10) {
//                flag = true;
//                temp = temp - 10;
//            } else {
//                flag = false;
//            }
//            sb.append(temp);
//            i++;
//        }
//        while (i < a.length()) {
//            int t1 = a.charAt(a.length() - 1 - i) - '0';
//            if (flag) {
//                t1++;
//            }
//            if (t1 >= 10) {
//                t1 = 0;
//                flag = true;
//            } else {
//                flag = false;
//            }
//            sb.append(t1);
//            i++;
//        }
//        while (i < b.length()) {
//            int t1 = b.charAt(b.length() - 1 - i) - '0';
//            if (flag) {
//                t1++;
//            }
//            if (t1 >= 10) {
//                t1 = 0;
//                flag = true;
//            } else {
//                flag = false;
//            }
//            sb.append(t1);
//            i++;
//        }
//        if (flag) {
//            sb.append("1");
//        }
//        String t = sb.toString();
//        StringBuilder result = new StringBuilder();
//        for (int j = t.length() - 1; j >= 0; j--) {
//            result.append(t.charAt(j));
//        }
//        return result.toString();
//    }
//
//    public String countPer(String num1, char num, int zeroCount) {
//        int bit = 0;
//        StringBuilder sb = new StringBuilder();
//        while (zeroCount-- > 0) {
//            sb.append('0');
//        }
//        int multi = num - '0';
//        for (int i = num1.length() - 1; i >= 0; i--) {
//            int t = num1.charAt(i) - '0';
//            int temp = t * multi + bit;
//            if (temp >= 10) {
//                bit = temp / 10;
//                temp = temp % 10;
//            } else {
//                bit = 0;
//            }
//            sb.append(temp);
//        }
//        if (bit != 0) {
//            sb.append(bit);
//        }
//        String t = sb.toString();
//        StringBuilder result = new StringBuilder();
//        for (int i = t.length() - 1; i >= 0; i--) {
//            result.append(t.charAt(i));
//        }
//        return result.toString();
//    }
}
