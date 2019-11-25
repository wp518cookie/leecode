package first.easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Convert_a_Number_to_Hexadecimal_405 {
    public static void main(String[] args) {
        System.out.println(toHex(-1));
    }

    public static String toHex(int num) {
        String result = "";
        if (num == 0) {
            return "0";
        }
        int temp_num = 0;
        if (num < 0) {
            temp_num = ~(num*(-1)) + 1;
        } else {
            temp_num = num;
        }
        String s = Integer.toBinaryString(temp_num);
        while (s.length() > 0) {
            String temp = "";
            if (s.length() > 4) {
                temp = s.substring(s.length()-4, s.length());
            } else {
                temp = s;
            }
            int temp1 = Integer.parseInt(temp, 2);
            if (temp1 > 9) {
                char temp2 = (char) (temp1 - 10 + 97);
                result = temp2 + result;
            } else {
                result = temp1 + result;
            }
            if (s.length() <= 4) {
                break;
            } else {
                s = s.substring(0, s.length()-4);
            }
        }
        return result;
    }
}
