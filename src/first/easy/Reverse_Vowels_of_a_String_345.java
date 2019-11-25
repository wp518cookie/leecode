package first.easy;

/**
 * Created by ping.wu on 2017/1/20.
 */
public class Reverse_Vowels_of_a_String_345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean i_flag = false;
        boolean j_flag = false;
        char[] real_arr = s.toCharArray();
        char[] arr = s.toLowerCase().toCharArray();
        while (i < j) {
            if (!i_flag && arr[i] != 'a' && arr[i] != 'o' && arr[i] != 'e' && arr[i] != 'i' && arr[i] != 'u') {
                i++;
            } else {
                i_flag = true;
            }
            if (!j_flag && arr[j] != 'a' && arr[j] != 'o' && arr[j] != 'e' && arr[j] != 'i' && arr[j] != 'u') {
                j--;
            } else {
                j_flag = true;
            }
            if (i_flag && j_flag) {
                char temp = real_arr[i];
                real_arr[i++] = real_arr[j];
                real_arr[j--] = temp;
                i_flag = false;
                j_flag = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char t : real_arr) {
            sb.append(t);
        }
        return sb.toString();
    }
}
