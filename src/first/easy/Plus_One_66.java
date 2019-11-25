package first.easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Plus_One_66 {
    public static void main(String[] args) {

    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + 1;
            if (temp < 10) {
                digits[i] = temp;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }
    }
}
