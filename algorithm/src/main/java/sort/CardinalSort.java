package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardinalSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int location = 1;
        ArrayList<ArrayList<Integer>> buckList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckList.add(new ArrayList());
        }
        while(true) {
            int dd = (int)Math.pow(10, (location - 1));
            if (max < dd) break;
            for (int i = 0; i < len; i++) {
                int number = ((arr[i] / dd) % 10);
                buckList.get(number).add(arr[i]);
            }
            int nn = 0;
            for (int i = 0; i < 10; i++) {
                int size = buckList.get(i).size();
                for (int ii = 0; ii < size; ii++) {
                    arr[nn++] = buckList.get(i).get(ii);
                }
                buckList.get(i).clear();
            }
            location++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 5};
        sort(arr);
        for (int num:
                arr) {
            System.out.println(num);
        }
    }
}
