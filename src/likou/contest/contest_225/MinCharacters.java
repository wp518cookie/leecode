package likou.contest.contest_225;

/**
 * @author wuping
 * @date 2021-01-24
 * https://leetcode-cn.com/contest/weekly-contest-225/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/
 */

public class MinCharacters {
    public static void main(String[] args) {
//        String a = "a", b = "b";
        String a = "cc", b= "abca";
        System.out.println(new MinCharacters().minCharacters(a, b));
    }

    public int minCharacters(String a, String b) {
        int[] aArr = new int[26];
        int[] bArr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            int idx = a.charAt(i) - 97;
            aArr[idx]++;
        }
        for (int i = 0; i < b.length(); i++) {
            int idx = b.charAt(i) - 97;
            bArr[idx]++;
        }

        int count = Integer.MAX_VALUE;

        int preA = aArr[0];
        int preB = bArr[0];
        for (int i = 1; i < 25; i++) {
            count = Math.min(count, preA + b.length() - preB - bArr[i] + Math.min(aArr[i], bArr[i]));
            count = Math.min(count, preB + a.length() - preA - aArr[i] + Math.min(aArr[i], bArr[i]));
            preA += aArr[i];
            preB += bArr[i];
        }

        if (a.length() == b.length()) {
            count = Math.min(count, countIfSameChar(a, aArr, b, bArr));
        }
        return count;
    }

    public int countIfSameChar(String a, int[] aArr, String b, int[] bArr) {
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            count = Math.min(count, a.length() - aArr[i] + b.length() - bArr[i]);
        }
        return count;
    }
}
