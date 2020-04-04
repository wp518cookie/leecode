package likou.first_try.top;

/**
 * @author wuping
 * @date 2020-04-04
 */

public class TitleToNumber_171 {
    public int titleToNumber(String s) {
        int num = 0;
        int count = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = (s.charAt(i) - 'A' + 1) * count + num;
            count = count * 26;
        }
        return num;
    }
}
