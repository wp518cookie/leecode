package first.easy;

/**
 * Created by ping.wu on 2016/12/30.
 */
public class Add_Strings_415 {
    public static void main(String[] args) {
        System.out.println(addStrings("123456789", "987654321"));
    }

    public static String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int gap = num1.length() - num2.length();
        while (gap-- > 0) {
            num2 = "0" + num2;
        }
        char[] a_arr = num1.toCharArray();
        char[] b_arr = num2.toCharArray();
        int[] result_arr = new int[b_arr.length + 1];
        boolean digit = false;
        for (int i = a_arr.length - 1; i >= 0; i--) {
            int temp_result = a_arr[i] + b_arr[i] - 48 - 48;
            if (digit) {
                temp_result++;
                digit = false;
            }
            if (temp_result >= 10) {
                result_arr[i + 1] = temp_result % 10;
                digit = true;
            } else {
                result_arr[i + 1] = temp_result;
            }
        }
        if (digit) {
            result_arr[0] = 1;
        }
        StringBuilder sb = new StringBuilder();
        int j = 1;
        if (digit) {
            j = 0;
        }
        for (; j < result_arr.length; j++) {
            sb.append(result_arr[j]);
        }
        return sb.toString();
    }
}
