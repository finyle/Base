package sort;

public class InsertSort {
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int j = 0;
            for (j = i - 1; j > 0; j--) {
                if (arr[j] > val) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = val;
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
