package likou.daily_problem.july_2020;

import java.util.Map;

/**
 * @author wuping
 * @date 2020-08-19
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 *Manacher 算法是在线性时间内求解最长回文子串的算法。在本题中，我们要求解回文串的个数，为什么也能使用 Manacher 算法呢？这里我们就需要理解一下 Manacher 的基本原理。
 *
 * Manacher 算法也会面临「方法一」中的奇数长度和偶数长度的问题，它的处理方式是在所有的相邻字符中间插入 \##，比如 abaaabaa 会被处理成 \#a\#b\#a\#a\##a#b#a#a#，这样可以保证所有找到的回文串都是奇数长度的，以任意一个字符为回文中心，既可以包含原来的奇数长度的情况，也可以包含原来偶数长度的情况。假设原字符串为 SS，经过这个处理之后的字符串为 ss。
 *
 * 我们用 f(i)f(i) 来表示以 ss 的第 ii 位为回文中心，可以拓展出的最大回文半径，那么 f(i) - 1f(i)−1 就是以 ii 为中心的最大回文串长度 （想一想为什么）。
 *
 * Manacher 算法依旧需要枚举 ss 的每一个位置并先假设它是回文中心，但是它会利用已经计算出来的状态来更新 f(i)f(i)，而不是向「中心拓展」一样盲目地拓展。具体地说，假设我们已经计算好了 [1, i - 1][1,i−1] 区间内所有点的 ff（即我们知道 [1, i - 1][1,i−1] 这些点作为回文中心时候的最大半径）， 那么我们也就知道了 [1, i - 1][1,i−1] 拓展出的回文达到最大半径时的回文右端点。例如 i = 4i=4 的时候 f(i) = 5f(i)=5，说明以第 44 个元素为回文中心，最大能拓展到的回文半径是 55，此时右端点为 4 + 5 - 1 = 84+5−1=8。所以当我们知道一个 ii 对应的 f(i)f(i) 的时候，我们就可以很容易得到它的右端点为 i + f(i) - 1i+f(i)−1。
 *
 * Manacher 算法如何通过已经计算出的状态来更新 f(i)f(i) 呢？Manacher 算法要求我们维护「当前最大的回文的右端点 r_mr
 * m
 * ​
 *  」以及这个回文右端点对应的回文中心 i_mi
 * m
 * ​
 *  。我们需要顺序遍历 ss，假设当前遍历的下标为 ii。我们知道在求解 f(i)f(i) 之前我们应当已经得到了从 [1, i - 1][1,i−1] 所有的 ff，并且当前已经有了一个最大回文右端点 r_mr
 * m
 * ​
 *   以及它对应的回文中心 i_mi
 * m
 * ​
 *  。
 *
 * 初始化 f(i)f(i)
 * 如果 i \leq r_mi≤r
 * m
 * ​
 *  ，说明 ii 被包含在当前最大回文子串内，假设 jj 是 ii 关于这个最大回文的回文中心 i_mi
 * m
 * ​
 *   的对称位置（即 j + i = 2 \times i_mj+i=2×i
 * m
 * ​
 *  ），我们可以得到 f(i)f(i) 至少等于 \min\{f(j), r_m - i + 1\}min{f(j),r
 * m
 * ​
 *  −i+1}。这里将 f(j)f(j) 和 r_m - i + 1r
 * m
 * ​
 *  −i+1 取小，是先要保证这个回文串在当前最大回文串内。（思考：为什么 f(j)f(j) 有可能大于 r_m - i + 1r
 * m
 * ​
 *  −i+1？）
 *
 * 如果 i > r_mi>r
 * m
 * ​
 *  ，那就先初始化 f(i) = 1f(i)=1。
 *
 * 中心拓展
 * 做完初始化之后，我们可以保证此时的 s[i + f(i) - 1] = s[i - f(i) + 1]s[i+f(i)−1]=s[i−f(i)+1]，要继续拓展这个区间，我们就要继续判断 s[i + f(i)]s[i+f(i)] 和 s[i - f(i)]s[i−f(i)] 是否相等，如果相等将 f(i)f(i) 自增；这样循环直到 s[i + f(i)] \neq s[i - f(i)]s[i+f(i)]
 * 
 * ​
 *  =s[i−f(i)]，以此类推。我们可以看出循环每次结束时都能保证 s[i + f(i) - 1] = s[i - f(i) + 1]s[i+f(i)−1]=s[i−f(i)+1]，而循环继续（即可拓展的条件）一定是 s[i + f(i)] = s[i - f(i)]s[i+f(i)]=s[i−f(i)]。 这个时候我们需要注意的是不能让下标越界，有一个很简单的办法，就是在开头加一个 \$$，并在结尾加一个 !!，这样开头和结尾的两个字符一定不相等，循环就可以在这里终止。
 * 这样我们可以得到 ss 所有点为中心的最大回文半径，也就能够得到 SS 中所有可能的回文中心的的最大回文半径，把它们累加就可以得到答案。
 */

public class CountSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new CountSubstrings().countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
//
//    /**
//     * 时间复杂度：O(n^2)，空间复杂度：O(n)
//     * @param s
//     * @return
//     */
//    public int countSubstrings(String s) {
//        int n = s.length();
//        int result = 0;
//        for (int i = 0; i < n * 2 - 1; i++) {
//            int l = i / 2;
//            int r = i / 2 + i % 2;
//            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
//                result++;
//                l--;
//                r++;
//            }
//        }
//        return result;
//    }

    /**
     * O(N^3) 时间复杂度
     * @param s
     * @return
     */
//    public int countSubstrings(String s) {
//        int result = 0;
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = i; j < s.length(); j++) {
//                if (ifPalindromic(s, i, j)) {
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private boolean ifPalindromic(String s, int start, int end) {
//        if (start == end) {
//            return true;
//        }
//        while (start < end) {
//            if (s.charAt(start) != s.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }
}
