package medium;

import java.util.regex.Pattern;

/**
 * Created by ping.wu on 2016/12/20.
 */
public class Longest_Absolute_File_Path_388 {
    public int lengthLongestPath(String input) {
        if (input == null || input.trim().equals("")) {
            return 0;
        }
        String s = "dir\n\\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        Pattern pattern1 = Pattern.compile("\\n");
        pattern1.matcher(s);
        return 0;
    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        StringBuilder sb = new StringBuilder("\n\t");
        int i = s.indexOf(sb.toString());
        while (i != -1) {

        }
    }
}
