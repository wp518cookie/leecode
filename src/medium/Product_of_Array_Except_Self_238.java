package medium;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/25.
 */
public class Product_of_Array_Except_Self_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp *= nums[i];
        }
        tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
