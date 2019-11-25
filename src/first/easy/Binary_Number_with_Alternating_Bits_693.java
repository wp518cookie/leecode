package first.easy;

/**
 * Created by Administrator on 2017/12/1.
 */
public class Binary_Number_with_Alternating_Bits_693 {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }

    public static boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        boolean zeroFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (zeroFlag) {
                if (s.charAt(i) == '0') {
                    zeroFlag = false;
                    continue;
                } else {
                    return false;
                }
            } else {
                if (s.charAt(i) == '1') {
                    zeroFlag = true;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
