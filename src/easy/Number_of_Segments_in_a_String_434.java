package easy;

/**
 * Created by Administrator on 2017/12/22.
 */
public class Number_of_Segments_in_a_String_434 {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }

    public static int countSegments(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
        }
        boolean beforeSpcae = false;
        char[] arr = s.trim().toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                if (beforeSpcae) {
                    continue;
                } else {
                    beforeSpcae = true;
                    count++;
                }
            } else {
                beforeSpcae = false;
            }
        }
        return count + 1;
    }
}
