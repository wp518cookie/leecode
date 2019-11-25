package first.medium;


/**
 * Created by ping.wu on 2016/12/20.
 */
public class Longest_Absolute_File_Path_388 {
    public static void lengthLongestPath(String input) {
        String s = "dir\n\tsubdir1\n\t\tfile.ext\n\tsubdir2\n\t\tfile2.ext";

    }

    public static void main(String[] args) {
        String s = "dir\n\tsubdir1\n\t\tfile.ext\n\tsubdir2\n\t\tfile2.ext";
        String[] temp = s.split("\n\t[^\n\t\t]");
        System.out.println(s.length());
    }
}
