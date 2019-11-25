package first.weekcontest;

/**
 * Created by Administrator on 2017/4/1.
 */
public class Perfect_number_507 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int flag = (int)Math.sqrt(num);
        int sum = 0;
        for (int i = 1; i <= flag; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        sum = sum - num;
        if (num == flag * flag) {
            sum = sum - flag;
        }
        if (sum != num) {
            return false;
        } else {
            return true;
        }
    }
}
