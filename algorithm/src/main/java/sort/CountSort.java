package sort;

public class CountSort {
    public static void sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        int[] countArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
            arr[i] = 0;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) arr[index++] = i;
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
