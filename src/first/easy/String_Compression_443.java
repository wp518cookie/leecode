package first.easy;

public class String_Compression_443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b'}));
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
                if (count > 1) {
                    allCount += (String.valueOf(count)).length() + 1;
                    count = 1;
                } else {
                    allCount++;
                }
            }
        }
        if (count == 1) {
            allCount++;
        } else {
            allCount += (String.valueOf(count)).length() + 1;
        }
        return allCount;
    }
}
