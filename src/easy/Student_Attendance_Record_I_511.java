package easy;

/**
 * Created by Administrator on 2017/12/18.
 */
public class Student_Attendance_Record_I_511 {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        char[] arr = s.toCharArray();
        boolean aFlag = false;
        boolean fFlag = false;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                if (aFlag) {
                    return false;
                } else {
                    aFlag = true;
                    fFlag = false;
                    count = 0;
                    continue;
                }
            } else if (arr[i] == 'L') {
                if (fFlag) {
                    count++;
                } else {
                    fFlag = true;
                    count++;
                }
                if (count > 2) {
                    return false;
                }
            } else {
                fFlag = false;
                count = 0;
            }
        }
        return true;
    }
}
