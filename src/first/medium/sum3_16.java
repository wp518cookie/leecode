package first.medium;

/**
 * Created by Administrator on 2018/3/2.
 */
public class sum3_16 {
    public static void main(String[] args) {
        threeSumClosest(new int[]{0, 0, 0}, 1);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Integer closest = null;
        find(closest, 0, 3, nums, 0, target);
        return closest.intValue();
    }

    private static void find(Integer closest, int temp, int k, int[] nums, int start, int target) {
        int min = nums[start];
        int max = nums[nums.length - 1];
        if (k == 2) {
            if (needContinue(closest, 2, temp, min, max, target)) {
                for (int i = start; i < nums.length - 1; i++) {
                    for (int j = start + 1; j < nums.length; j++) {
                        if (closest == null) {
                            closest = nums[i] + nums[j] + temp;
                            continue;
                        }
                        int gap = Math.abs(closest - target);
                        int tempGap = nums[i] + nums[j] + temp;
                        if (Math.abs(target - tempGap) < gap) {
                            gap = Math.abs(tempGap);
                            if ((closest = tempGap) == 0) {
                                return;
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = start; i < nums.length - k + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                int tempVal = nums[i];
                if (needContinue(closest, 2, tempVal, min, max, target)) {
                    find(closest, tempVal, 2, nums, start + 1, target);
                }
            }
        }
    }

    private static boolean needContinue(Integer closest, int k, int tempVal, int min, int max, int target) {
        if (closest == null) {
            return true;
        } else {
            if (closest < target) {
                if (tempVal + max * k < closest || tempVal + min * k > target + (target - closest)) {
                    return false;
                }
            } else if (closest > target) {
                if (tempVal + min * k > closest || tempVal + max * k < target - (closest - target)) {
                    return false;
                }
            }
        }
        return true;
    }
}
