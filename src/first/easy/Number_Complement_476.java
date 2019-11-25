package first.easy;

/**
 * Created by ping.wu on 2017/1/10.
 */
public class Number_Complement_476 {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        //101
    }

    public static int findComplement(int num) {
        return ((Integer.highestOneBit(5)<<1) - 1) ^ num;
    }
}
