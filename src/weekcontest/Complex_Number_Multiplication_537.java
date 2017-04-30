package weekcontest;

/**
 * Created by Administrator on 2017/4/1.
 */
public class Complex_Number_Multiplication_537 {
    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+1i", "1+1i"));
    }

    public static String complexNumberMultiply(String a, String b) {
        String[] array_a = a.split("\\+");
        String[] array_b = b.split("\\+");
        array_a[1] = array_a[1].replace("i", "");
        array_b[1] = array_b[1].replace("i", "");
        int a1 = Integer.valueOf(array_a[0]);
        int a2 = Integer.valueOf(array_a[1]);
        int b1 = Integer.valueOf(array_b[0]);
        int b2 = Integer.valueOf(array_b[1]);
        int real = a1 * b1 - a2 * b2;
        int image = a1 * b2 + a2 * b1;
        String result = String.valueOf(real) + "+" + String.valueOf(image) + "i";
        return result;
    }
}
