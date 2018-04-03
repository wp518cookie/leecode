package easy;

/**
 * Created by Administrator on 2018/3/20.
 */
public class Onebit_and_2_bit_Characters_717 {
    public static void main(String[] args) {
        System.out.println(isOneBitCharacter(new int[]{0, 0}));
    }
    public static boolean isOneBitCharacter(int[] bits) {
        boolean flag = false;
        for (int i = 0; i < bits.length - 1; i++) {
            if (bits[i] == '0') {
                flag = false;
            } else {
                flag = !flag;
            }
        }
        if (!flag) {
            return true;
        } else {
            return false;
        }
    }
}
