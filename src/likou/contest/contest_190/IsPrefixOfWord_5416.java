package likou.contest.contest_190;

/**
 * @author wuping
 * @date 2020-05-24
 */

public class IsPrefixOfWord_5416 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.length() < searchWord.length()) {
                continue;
            }
            if (temp.indexOf(searchWord) == 0) {
                return i + 1;
            }
        }
        return -1;
    }
}
