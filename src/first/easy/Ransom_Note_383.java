package first.easy;

/**
 * Created by ping.wu on 2016/12/30.
 */
public class Ransom_Note_383 {
    public static void main(String[] args) {
        String ransomNote = "fffbfg";
        String magazine = "effjfggbffjdgbjjhhdegh";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom_arr = ransomNote.toCharArray();
        char[] magazine_arr = magazine.toCharArray();
        int[] ransom_int = new int[26];
        int[] magazine_int = new int[26];
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        for (int i = 0; i < ransom_arr.length; i++) {
            int temp = ransom_arr[i] - 97;
            ransom_int[temp] = ransom_int[temp] + 1;
        }
        for (int i = 0; i < magazine_arr.length; i++) {
            int temp = magazine_arr[i] - 97;
            magazine_int[temp] = magazine_int[temp] + 1;
        }
        for (int i = 0; i < 26; i++) {
            if (ransom_int[i] > magazine_int[i]) {
                return false;
            }
        }
        return true;
    }
}
