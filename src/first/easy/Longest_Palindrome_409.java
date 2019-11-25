package first.easy;

/**
 * Created by ping.wu on 2017/1/10.
 */
public class Longest_Palindrome_409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public static int longestPalindrome(String s) {
        int length = 0;
        boolean flag = false;
        int[] result = new int[58];
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 65]++;
        }
        for (int i = 0; i < 58; i++) {
            if (result[i] % 2 == 0) {
                length += result[i];
            } else {
                length += result[i] - 1;
                flag = true;
            }
        }
        if (flag) {
            return length + 1;
        } else {
            return length;
        }
    }
}
