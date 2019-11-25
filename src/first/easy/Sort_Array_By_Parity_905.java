package first.easy;

/**
 * @author wuping
 * @date 2018/9/19
 */

public class Sort_Array_By_Parity_905 {
    public static void main(String[] args) {

    }

    public static int[] sortArrayByParity(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] result = new int[arr.length];
        int i = 0;
        int j = arr.length - 1;
        for (int k = 0; k < arr.length; k++) {
            int t = arr[k];
            if (t % 2 == 0) {
                result[i++] = t;
            } else {
                result[j--] = t;
            }
        }
        return result;
    }
}
