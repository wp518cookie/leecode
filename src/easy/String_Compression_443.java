/*
package easy;

*/
/**
 * Created by Administrator on 2017/12/22.
 *//*

public class String_Compression_443 {
    public static void main(String[] args) {

    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        char before = chars[0];
        int count = 1;
        int allCount = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == before) {
                count++;
            } else {
                before = chars[i];

            }
        }
    }
}
*/
