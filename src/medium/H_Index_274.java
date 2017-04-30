package medium;

/**
 * Created by ping.wu on 2017/1/18.
 */
public class H_Index_274 {
    public static void main(String[] args) {
        int[] citation = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citation));
    }
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        for (int i = 0; i < citations.length; i++) {
            int max = i;
            for (int j = i; j < citations.length; j++) {
                if (citations[max] < citations[j]) {
                    max = j;
                }
            }
            int temp = citations[i];
            citations[i] = citations[max];
            citations[max] = temp;
         }
        for (int i = 0; i < citations.length; i++) {
            if ((i+1) > citations[i]) {
                return i;
            }
        }
        return citations.length;
    }
}
