package first.tree;

import java.util.List;

/**
 * @author wuping
 * @date 2019-12-12
 * https://leetcode.com/problems/keys-and-rooms/
 *
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 */

public class Keys_and_Rooms_841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] flag = new boolean[rooms.size()];
        dfs(0, rooms, flag);
        for (boolean meta : flag) {
            if (!meta) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int roomId, List<List<Integer>> rooms, boolean[] flag) {
        flag[roomId] = true;
        List<Integer> keys = rooms.get(roomId);
        for (Integer key : keys) {
            if (!flag[key]) {
                dfs(key, rooms, flag);
            }
        }
    }
}
