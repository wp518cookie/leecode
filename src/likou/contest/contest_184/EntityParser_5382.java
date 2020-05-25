package likou.contest.contest_184;

/**
 * @author wuping
 * @date 2020-04-12
 * https://leetcode-cn.com/contest/weekly-contest-184/problems/html-entity-parser/
 */

public class EntityParser_5382 {
    public static void main(String[] args) {
        System.out.println(new EntityParser_5382().entityParser("Stay home! Practice on Leetcode :)"));
    }

    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        for (int i = 0; i < length; ) {
            char t = text.charAt((i));
            if (t == '&') {
                if (i + 3 < length && text.charAt(i + 3) == ';') {
                    if (text.charAt(i + 1) == 'l' && (text.charAt(i + 2)) == 't') {
                        sb.append("<");
                        i = i + 4;
                    } else if (text.charAt(i + 1) == 'g' && (text.charAt(i + 2)) == 't') {
                        sb.append(">");
                        i = i + 4;
                    } else {
                        sb.append('&');
                        i++;
                    }
                } else if (i + 4 < length && text.charAt(i + 4) == ';') {
                    if (text.charAt(i + 1) == 'a' && text.charAt(i + 2) == 'm' && text.charAt(i + 3) == 'p') {
                        sb.append("&");
                        i = i + 5;
                    } else {
                        sb.append('&');
                        i++;
                    }
                } else if (i + 5 < length && text.charAt(i + 5) == ';') {
                    if (text.charAt(i + 1) == 'q' && text.charAt(i + 2) == 'u' && text.charAt(i + 3) == 'o' && text.charAt(i + 4) == 't') {
                        sb.append('"');
                        i = i + 6;
                    } else if (text.charAt(i + 1) == 'a' && text.charAt(i + 2) == 'p' && text.charAt(i + 3) == 'o' && text.charAt(i + 4) == 's') {
                        sb.append("'");
                        i = i + 6;
                    } else {
                        sb.append('&');
                        i++;
                    }
                } else if (i + 6 < length && text.charAt(i + 6) == ';') {
                    if (text.charAt(i + 1) == 'f' && text.charAt(i + 2) == 'r' && text.charAt(i + 3) == 'a' && text.charAt(i + 4) == 's' && text.charAt(i + 5) == 'l') {
                        sb.append('/');
                        i = i + 7;
                    } else {
                        sb.append('&');
                        i++;
                    }
                } else {
                    sb.append(t);
                    i++;
                }
            } else {
                sb.append(t);
                i++;
            }
        }
        return sb.toString();
    }
}