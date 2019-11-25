package first.easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Ugly_Number_263 {
    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }

    public static boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                break;
            }
        }
        return num == 1;
    }
}
