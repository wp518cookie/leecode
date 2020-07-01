package likou.company.bytedance.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuping
 * @date 2020-06-29
 * <p>
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1044/
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */

public class RestoreIpAddresses {
    public static void main(String[] args) {
        List<String> result = new RestoreIpAddresses().restoreIpAddresses("0000");
        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList();
        restoreIpAddresses(s, 4, new ArrayList(), result);
        return result;
    }

    public void restoreIpAddresses(String s, int count, List<String> current, List<String> result) {
        if (s.length() < count) {
            return;
        }
        if (count == 1) {
            if (s.length() > 3 || Integer.valueOf(s) > 255) {
                return;
            }
            if (s.charAt(0) == '0' && s.length() > 1) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String t : current) {
                sb.append(t);
                sb.append(".");
            }
            sb.append(s);
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (s.charAt(0) == '0' && i > 0) {
                break;
            }
            if (s.length() - i - 1 < count - 1) {
                break;
            }
            String t = s.substring(0, i + 1);
            if (Integer.valueOf(t) > 255) {
                break;
            }
            current.add(t);
            restoreIpAddresses(s.substring(i + 1), count - 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
