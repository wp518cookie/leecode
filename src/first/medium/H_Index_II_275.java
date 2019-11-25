package first.medium;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class H_Index_II_275 {
    public static void main(String[] args) {
        int[] citation = {0, 1, 3, 5, 6};
        System.out.println(hIndex(citation));
    }
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        for (int i = citations.length - 1; i >= 0; i--) {
            if ((citations.length - i) > citations[i]) {
                return citations.length - i - 1;
            }
        }
        return citations.length;
    }
}
