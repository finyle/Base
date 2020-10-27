package sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void sort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }

        int index = 0;
        for(ArrayList<Integer> arrayList : bucketArr){
            for(int value : arrayList){
                arr[index] = value;
                index++;
            }
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
