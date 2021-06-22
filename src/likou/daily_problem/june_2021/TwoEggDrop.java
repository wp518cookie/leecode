package likou.daily_problem.june_2021;

/**
 * @author wuping
 * @date 2021-06-21
 *
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，
 * 从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 *
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，
 * 则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 *
 * 示例 2：
 * 输入：n = 100
 * 输出：14
 *
 * 提示：
 * 1 <= n <= 1000
 *
 * https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/
 */

public class TwoEggDrop {
    // 解法：https://leetcode-cn.com/problems/egg-drop-with-2-eggs-and-n-floors/solution/lai-zi-mei-guo-zhan-shuang-100shi-jian-f-y8m0/


    // recursion
    public int twoEggDropByRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //todo
        return 0;
    }
}
