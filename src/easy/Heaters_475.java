package easy;

import java.util.Arrays;

/**
 * Created by ping.wu on 2017/2/23.
 */
public class Heaters_475 {
    public static void main(String[] args) {
        int[] houses = {101027544,144108930,282475249,457850878,458777923,470211272,622650073,984943658};
        int[] heaters = {16531729,74243042,114807987,115438165,137522503,143542612,441282327,784484492,823378840,823564440,181367746};
        //161834419          181367746
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int hou_h = 0;
        int hou_e = houses.length - 1;
        int hea_h = 0;
        int hea_e = heaters.length - 1;
        int radius = 0;
        while (hou_h < hou_e) {
            if (houses[hou_h] > heaters[hea_h] + radius) {
                int min = heaters[hea_h] - houses[hou_h];
                int idx = hea_h;
                if (min < 0) {
                    min = min * (-1);
                }
                for (int i = hea_h + 1; i <= hea_e; i++) {
                    int temp = heaters[i] - houses[hou_h];
                    if (temp < 0) {
                        temp = temp * (-1);
                        if (min > temp) {
                            min = temp;
                            idx = i;
                        }
                    }
                }
                hea_h = idx;
                hou_h++;
                radius = radius > min ? radius : min;
            } else {
                hou_h++;
            }
            if (houses[hou_e] < heaters[hea_e] - radius) {
                int min = heaters[hea_e] - houses[hou_e];
                int idx = hea_e;
                if (min < 0) {
                    min = min * (-1);
                }
                for (int i = hea_h; i < hea_e; i++) {
                    int temp = heaters[i] - houses[hou_e];
                    if (temp < 0) {
                        temp = temp * (-1);
                        if (min > temp) {
                            min = temp;
                            idx = i;
                        }
                    }
                }
                hea_e = idx;
                hou_e--;
                radius = radius > min ? radius : min;
            } else {
                hou_e--;
            }
        }
        return radius;
    }
}
