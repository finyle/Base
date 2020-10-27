package sort;

public class ShellSort {
    public static void sort(int[] arr) {
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int val = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > val) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = val;
            }
            gap = gap / 3;
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
