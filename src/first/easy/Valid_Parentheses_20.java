package first.easy;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/3/9.
 */
public class Valid_Parentheses_20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        } else {
            LinkedList<Integer> list = new LinkedList();
            for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                if (temp == 40) {
                    list.push(41);
                } else if (temp == 91) {
                    list.push(93);
                } else if (temp == 123) {
                    list.push(125);
                } else {
                    if (list.isEmpty()) {
                        return false;
                    } else if (list.pop() != temp) {
                        return false;
                    }
                }
            }
            return list.size() == 0;
        }
    }
}
